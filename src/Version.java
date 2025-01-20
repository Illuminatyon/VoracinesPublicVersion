import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.InetAddress;
import org.json.JSONArray;
import org.json.JSONObject;

public class Version {
    // Déclaration des constantes liées au dépôt GitHub
    private static final String PROPRIO_REPO = "BKxing4K";  // Propriétaire du dépôt
    private static final String NOM_REPO = "VoracinesPublique";  // Nom du dépôt
    private static final String BRANCHE = "main";  // Branche du dépôt
    private static final String CHEMIN_RELATIF = System.getProperty("user.dir");  // Répertoire de travail actuel

    // Méthode pour vérifier la connexion internet en tentant de résoudre une adresse IP
    public static boolean verifierConnexion() {
        try {
            System.out.println("\033[0;38mVérification de la connexion en cours...\n");
            System.out.println("Tentative de résolution de l'adresse IP...");
            InetAddress adresseIP = InetAddress.getByName("9.9.9.11"); // Adresse IP utilisée pour tester la connexion
            System.out.println(Affichage.VERT + "Adresse IP résolue : " + adresseIP.getHostAddress() + "\n");
            System.out.println(Affichage.JAUNE + "Vérification si l'adresse IP est joignable...");

            // Déterminer le système d'exploitation et ajuster la commande de ping
            String os = System.getProperty("os.name").toLowerCase();
            String command;
            if (os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                command = "ping -c 1 " + adresseIP.getHostAddress();  // Commande ping pour systèmes Unix
            } else {
                command = "ping -n 1 " + adresseIP.getHostAddress();  // Commande ping pour systèmes Windows
            }

            // Exécution de la commande ping et obtenir le code de retour
            Process process = Runtime.getRuntime().exec(command);
            int returnCode = process.waitFor();

            // Vérification du code de retour pour déterminer si la connexion a réussi
            if (returnCode == 0) {
                System.out.println(Affichage.VERT + "Succès de la connexion !\n" + Affichage.RESET);
                return true; // Connexion réussie
            } else {
                System.out.println(Affichage.ROUGE + "Echec de la connexion !\n" + Affichage.RESET);
                return false; // Connexion échouée
            }
        } catch (Exception exception) {
            // Si une exception se produit (ex : pas d'internet), retourner false
            return false;
        }
    }

    // Méthode pour vérifier si une mise à jour est disponible en comparant les versions
    public static boolean verifierMiseAJour(String versionActuelle, String urlNouvelleVersion) {
        try {
            URL url = new URL(urlNouvelleVersion);  // URL pour vérifier la nouvelle version

            // Connexion HTTP pour récupérer la version à jour
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Vérification du code de réponse HTTP
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.err.println("Erreur lors de la récupération de la version: Code HTTP " + responseCode);
                return false;  // Si la réponse n'est pas 200, la mise à jour échoue
            }

            // Lire le contenu de la réponse HTTP qui contient la nouvelle version
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);  // Ajouter chaque ligne de la réponse au contenu
            }
            in.close();
            connection.disconnect();  // Fermer la connexion

            // Comparer la version actuelle avec la version disponible
            String nouvelleVersion = content.toString().trim(); // Récupérer la nouvelle version
            return !versionActuelle.equals(nouvelleVersion);  // Retourner true si la version a changé

        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            return false;  // En cas d'erreur, retourner false
        }
    }

    // Méthode pour télécharger et mettre à jour les fichiers à partir du dépôt GitHub
    public static void mettreAJourFichiers() {
        try {
            // URL de l'API GitHub pour obtenir les fichiers du dépôt
            String apiUrl = "https://api.github.com/repos/" + PROPRIO_REPO + "/" + NOM_REPO + "/contents/?ref=" + BRANCHE;

            // Connexion HTTP à l'API pour récupérer la liste des fichiers
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            // Vérification du code de réponse HTTP
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.err.println("Erreur lors de la récupération des fichiers : Code HTTP " + responseCode);
                return;  // Si l'API ne répond pas correctement, quitter la méthode
            }

            // Lire le contenu de la réponse HTTP qui contient les informations des fichiers
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);  // Ajouter chaque ligne de la réponse au contenu
            }
            reader.close();

            // Parser la réponse JSON pour obtenir les informations sur les fichiers
            JSONArray fichiers = new JSONArray(response.toString());
            for (int i = 0; i < fichiers.length(); i++) {
                JSONObject fichier = fichiers.getJSONObject(i);
                String nomFichier = fichier.getString("name");
                String urlTelechargement = fichier.getString("download_url");

                // Si un fichier a une URL de téléchargement, le télécharger
                if (urlTelechargement != null) {
                    telechargerFichier(urlTelechargement, CHEMIN_RELATIF + "/" + nomFichier);
                }
            }

            System.out.println("Mise à jour des fichiers terminée.");
        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }
    }

    // Méthode pour télécharger un fichier à partir de son URL et le sauvegarder localement
    private static void telechargerFichier(String urlTelechargement, String cheminRelatif) {
        try {
            // Connexion pour télécharger le fichier
            HttpURLConnection connection = (HttpURLConnection) new URL(urlTelechargement).openConnection();
            connection.setRequestMethod("GET");

            // Vérifier le code de réponse HTTP
            if (connection.getResponseCode() != 200) {
                System.err.println("Impossible de télécharger le fichier : " + urlTelechargement);
                return;  // Si le téléchargement échoue, quitter la méthode
            }

            // Lire le fichier téléchargé et l'écrire localement
            InputStream inputStream = connection.getInputStream();
            File fichierLocal = new File(cheminRelatif);
            fichierLocal.getParentFile().mkdirs();  // Créer les dossiers nécessaires

            try (FileOutputStream outputStream = new FileOutputStream(fichierLocal)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);  // Écrire les données du fichier
                }
            }

            System.out.println("Fichier téléchargé : " + cheminRelatif);
        } catch (Exception e) {
            System.err.println("Erreur lors du téléchargement du fichier : " + e.getMessage());
        }
    }
}
