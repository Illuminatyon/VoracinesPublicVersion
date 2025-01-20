/*
Voracines

CREDITS
Propriété intellectuelle de :
- Léo HONGSAVANH
- Luna ARDJAL
- Antoine PEZZULO
- Jazz FERRY
- Victor LE FLOCH
- Victor LOPEZ
Programmation par :
- Fabio GUERREIRO MARQUES
- Akram BARRA
*/

public class Lanceur {
    public static boolean quitter = false;
    /**
     * Point d'entrée principal du programme.
     * Cette méthode gère l'exécution initiale du jeu, notamment la vérification de mise à jour,
     * et l'affichage du menu principal du programme. Elle boucle jusqu'à ce que le joueur décide de quitter.
     * Étapes principales :
     * 1. Vérification de la connexion Internet.
     * 2. Vérification et gestion des mises à jour disponibles.
     * 3. Gestion du menu principal.
     * 4. Fermeture propre des ressources (exemple : scanner).
     *
     * @param args Les arguments de la ligne de commande passés au programme.
     */
    public static void main(String[] args) {
        /*
        if (Version.verifierConnexion()) {
            if (Version.verifierMiseAJour("0.0", "https://raw.githubusercontent.com/BKxing4K/VoracinesPublique/refs/heads/main/version.txt")) {
                String reponse = Affichage.saisirChaine(Affichage.JAUNE + "Une mise à jour est disponible." + Affichage.RESET + "\nSouhaitez vous mettre à jour le jeu ? (" + Affichage.VERT + "o" + Affichage.RESET + "/" + Affichage.ROUGE + "n" + Affichage.RESET + ")\n> ");
                if (reponse.equalsIgnoreCase("o") || reponse.equalsIgnoreCase("y") || reponse.equalsIgnoreCase("oui") || reponse.equalsIgnoreCase("yes")) {
                    Version.mettreAJourFichiers();
                    quitter = true;
                }
            }
        }
         */

        while (!quitter) {
            Menu.afficherMenu1();
        }
        Affichage.scanner.close();
    }
}
