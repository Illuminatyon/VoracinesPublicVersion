import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Classe Client permettant de se connecter à un serveur via un socket et de communiquer avec celui-ci.
 * Le client saisit une adresse hôte, envoie un mot de passe pour s'authentifier,
 * et interagit ensuite avec le serveur en fonction des instructions reçues.
 */
public class Client {
    /**
     * Port utilisé pour établir la connexion avec le serveur.
     */
    private static final int PORT = 7080;

    /**
     * Méthode principale pour établir une connexion au serveur, gérer l'authentification
     * et échanger des données.
     */
    public static void connectionAuServeur() {
        Scanner scanner = new Scanner(System.in);
        String adresseHote;

        // Demander à l'utilisateur de saisir une adresse d'hôte jusqu'à ce qu'elle soit valide.
        do {
            adresseHote = Affichage.saisirChaine(Affichage.VERT + "Saisissez l'adresse de l'hôte : " + Affichage.RESET);
        } while (adresseHote.isEmpty());

        try (
                // Création d'une socket pour se connecter au serveur.
                Socket socket = new Socket(adresseHote, PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println("Serveur trouvé");

            // Lecture de la demande de mot de passe envoyée par le serveur.
            String demandeMotDePasse = in.readLine();
            System.out.print(demandeMotDePasse);

            // Saisie et envoi du mot de passe au serveur.
            String motDePasse = scanner.nextLine();
            out.println(motDePasse);

            // Lecture et affichage de la confirmation d'authentification par le serveur.
            String confirmation = in.readLine();
            System.out.println(confirmation);

            // Si l'authentification est réussie, le client doit saisir un pseudo.
            if (confirmation.contains("réussie")) {
                System.out.println("Le pseudo doit être unique, comporter entre 1 et 16 caractères, les espaces sont interdits");

                // Lecture de la demande du pseudo envoyée par le serveur.
                System.out.print(in.readLine());

                // Saisie et envoi du pseudo au serveur.
                out.println(scanner.nextLine());

                // Lecture et affichage des messages du serveur en boucle.
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            }

        } catch (UnknownHostException e) {
            // Gestion de l'erreur en cas d'hôte inconnu.
            System.err.println(Affichage.ROUGE + "Erreur : L'hôte " + adresseHote + " est inconnu." + Affichage.RESET);
        } catch (IOException e) {
            // Gestion des autres erreurs d'entrée/sortie.
            System.err.println(Affichage.ROUGE + "Erreur client : " + e.getMessage() + Affichage.RESET);
        }
    }
}
