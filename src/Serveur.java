import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
    // Définition du port sur lequel le serveur écoute les connexions
    private static final int PORT = 7080;

    // Liste contenant tous les clients connectés au serveur
    private static final List<ClientHandler> clients = new ArrayList<>();

    // Variables pour stocker l'IP publique et le mot de passe du salon
    private static String ipPublique;
    private static String motDePasse;

    // Démarre le serveur et gère les connexions des clients
    public static void demarrerServeur() {
        Affichage.nettoyerConsole(200); // Nettoie la console pour plus de lisibilité

        Scanner scanner = new Scanner(System.in); // Scanner pour lire les entrées de l'hôte
        Random random = new Random(); // Objet pour générer des valeurs aléatoires

        // Générer un mot de passe aléatoire à 5 chiffres
        motDePasse = String.valueOf(10000 + random.nextInt(99999));

        // Récupérer l'IP publique du serveur
        ipPublique = recupererIpPublique();

        String pseudo;

        // Demander à l'hôte de choisir un pseudo valide (1-16 caractères, sans espaces)
        System.out.println("Le pseudo doit contenir entre 1 et 16 caractères, les espaces sont interdits");
        do {
            pseudo = Affichage.saisirChaine(Affichage.VERT + "Saisissez votre pseudo : " + Affichage.RESET);
        } while(pseudo.isEmpty() || pseudo.length() > 16 || pseudo.contains(" "));

        try (ServerSocket serverSocket = new ServerSocket(PORT)) { // Créer le serveur pour accepter les connexions
            System.out.println("=== Serveur démarré ===");
            System.out.println("IP Publique: " + ipPublique);
            System.out.println("Mot de passe : " + motDePasse);
            System.out.println("En attente de joueurs...");

            // Thread pour écouter la commande de démarrage de la partie de l'hôte
            new Thread(() -> {
                while (true) {
                    System.out.println("Tapez 'start' pour lancer la partie :");
                    String commande = scanner.nextLine();
                    if (commande.equalsIgnoreCase("start")) {
                        lancerPartie(); // Démarre la partie lorsque la commande est 'start'
                        break;
                    }
                }
            }).start();

            // Boucle pour accepter les connexions des clients
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accepter une connexion client
                // Créer un gestionnaire pour ce client et démarrer un thread pour lui
                ClientHandler client = new ClientHandler(clientSocket);
                clients.add(client);
                new Thread(client).start(); // Démarrer le client dans un nouveau thread
            }
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        }
    }

    // Méthode pour lancer la partie et informer tous les clients que la partie commence
    private static void lancerPartie() {
        System.out.println("Lancement de la partie...");
        // Envoyer un message à tous les clients connectés pour les informer que la partie commence
        for (ClientHandler client : clients) {
            client.envoyerMessage("La partie commence !");
        }
        // Logique de la partie ici
    }

    // Classe interne ClientHandler pour gérer la communication avec chaque client
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private String pseudo; // Le pseudo du client
        private PrintWriter out; // Flux de sortie pour envoyer des messages au client

        // Constructeur pour initialiser le socket du client
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                this.out = out;

                // Demander le mot de passe pour se connecter au salon
                out.println(Affichage.VERT + "Saisissez le mot de passe : " + Affichage.RESET);
                String mdp = in.readLine(); // Attendre que le client entre le mot de passe

                // Vérifier si le mot de passe est correct
                if (!mdp.equals(motDePasse)) {
                    out.println(Affichage.ROUGE + "Mot de passe incorrect. Déconnexion" + Affichage.RESET);
                    socket.close(); // Fermer la connexion si le mot de passe est incorrect
                    return;
                }

                out.println("Connexion réussie !"); // Confirmer la connexion réussie

                String pseudo;
                // Vérification que le pseudo est valide et unique
                do {
                    out.println(Affichage.VERT + "Saisissez votre pseudo : " + Affichage.RESET);
                    pseudo = in.readLine(); // Attendre que le client entre son pseudo
                    // Vérifier les conditions de validité du pseudo
                    if (pseudo.isEmpty() || pseudo.length() > 16 || pseudo.contains(" ")) {
                        out.println("Le pseudo doit être non vide, contenir entre 1 et 16 caractères, et ne pas comporter d'espaces.");
                    } else if (isPseudoUnique(pseudo)) {
                        out.println("Ce pseudo est déjà pris, veuillez en choisir un autre.");
                    } else {
                        break; // Sortir de la boucle si le pseudo est valide
                    }
                } while (true);

                this.pseudo = pseudo; // Attribuer le pseudo au client
                synchronized (clients) {
                    clients.add(this); // Ajouter le client à la liste des clients
                }

                // Afficher dans la console que le client a rejoint le salon
                System.out.println(pseudo + " a rejoint le salon");
                envoyerMessageATous(pseudo + " a rejoint le salon"); // Informer tous les autres clients

            } catch (IOException e) {
                System.err.println("Erreur avec le client : " + e.getMessage());
            }
        }

        // Méthode pour envoyer un message à ce client
        public void envoyerMessage(String message) {
            if (out != null) {
                out.println(message);
            }
        }

        // Méthode pour envoyer un message à tous les clients
        public void envoyerMessageATous(String message) {
            for (ClientHandler client : clients) {
                client.envoyerMessage(message);
            }
        }
    }

    // Méthode pour récupérer l'IP publique du serveur en utilisant un service externe
    public static String recupererIpPublique() {
        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            return in.readLine(); // Retourne l'IP publique obtenue
        } catch (IOException e) {
            System.err.println("Impossible d'obtenir l'adresse IP publique.");
            return null;
        }
    }

    // Méthode pour vérifier si un pseudo est unique dans la liste des clients
    private static boolean isPseudoUnique(String pseudo) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client.pseudo != null && client.pseudo.equals(pseudo)) {
                    return true; // Le pseudo existe déjà
                }
            }
        }
        return false; // Le pseudo est unique
    }
}
