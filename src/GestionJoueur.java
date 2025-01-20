import java.util.ArrayList;

public class GestionJoueur {
    public static String[] couleurs = {"Vert", "Jaune", "Rouge", "Bleu", "Magenta"};

    /**
     * Affiche les couleurs disponibles et propose au joueur de sélectionner celle qu'il souhaite.
     *
     * @param couleursDisponibles
     * @param couleursJoueurs
     * @param indiceJoueur
     */
    public static void proposerCouleurs(ArrayList<String> couleursDisponibles, String[] couleursJoueurs, int indiceJoueur, String pseudoJoueur) {
        int choix;
        int j = 7;

        do {
            Affichage.nettoyerConsole(200);
            System.out.println(Affichage.GRAS + pseudoJoueur + Affichage.RESET);
            System.out.println("Choisissez une couleur parmi celles disponibles :");
            for (int i = 0; i < couleursDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + couleursDisponibles.get(i));
            }
            choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
            Audio.jouerSonSaisie(choix < 1 || choix > couleursDisponibles.size(), "error", "click");
        } while (choix < 1 || choix > couleursDisponibles.size());

        couleursJoueurs[indiceJoueur] = couleursDisponibles.get(choix - 1);
        couleursDisponibles.remove(choix - 1);
    }


    /**
     * Échange les éléments aux indice1 et indice2.
     *
     * @param file
     * @param indice1
     * @param indice2
     */
    public static void modifierOrdreFile(ArrayList<Integer> file, int indice1, int indice2) {
        int tmp = file.get(indice1);
        file.set(indice1, file.get(indice2));
        file.set(indice2, tmp);
    }


    public static void affecterPseudoJoueur(String[] pseudosJoueurs, int iJoueur, boolean joue2c2) {
        if (joue2c2) {
            do {
                Affichage.nettoyerConsole(200);
                System.out.println(Affichage.ROUGE + "Chaque pseudo doit être unique (casse ignoré) et comporter entre 1 et 16 caractères, les espaces sont interdits." + Affichage.RESET);
                System.out.println();
                if (iJoueur % 2 == 0) {
                    System.out.println(Affichage.GRAS + "Joueur " + (iJoueur + 1) + Affichage.RESET);
                } else {
                    System.out.println(Affichage.GRAS + "Joueur " + (iJoueur + 1) + Affichage.RESET + ", coéquipier(e) de " + pseudosJoueurs[iJoueur - 1]);
                }
                Logique.viderBuffer();
                pseudosJoueurs[iJoueur] = Affichage.saisirChaine(Affichage.VERT + "Saisissez votre pseudo : " + Affichage.RESET);
                Audio.jouerSonSaisie(pseudosJoueurs[iJoueur].isEmpty() || pseudosJoueurs[iJoueur].length() > 16 || pseudosJoueurs[iJoueur].contains(" ") || Logique.elementExisteDansTableauString(pseudosJoueurs, pseudosJoueurs[iJoueur], iJoueur), "error", "click");
                verifierPseudoIncorrecte(pseudosJoueurs, iJoueur);
            } while (pseudosJoueurs[iJoueur].isEmpty() || pseudosJoueurs[iJoueur].length() > 16 || pseudosJoueurs[iJoueur].contains(" ") || Logique.elementExisteDansTableauString(pseudosJoueurs, pseudosJoueurs[iJoueur], iJoueur));
        } else {
            do {
                Affichage.nettoyerConsole(200);
                System.out.println(Affichage.ROUGE + "Chaque pseudo doit être unique (casse ignoré) et comporter entre 1 et 16 caractères, les espaces sont interdits." + Affichage.RESET);
                System.out.println();
                System.out.println(Affichage.GRAS + "Joueur " + (iJoueur + 1) + Affichage.RESET);
                Logique.viderBuffer();
                pseudosJoueurs[iJoueur] = Affichage.saisirChaine(Affichage.VERT + "Saisissez votre pseudo : " + Affichage.RESET);
                Audio.jouerSonSaisie(pseudosJoueurs[iJoueur].isEmpty() || pseudosJoueurs[iJoueur].length() > 16 || pseudosJoueurs[iJoueur].contains(" ") || Logique.elementExisteDansTableauString(pseudosJoueurs, pseudosJoueurs[iJoueur], iJoueur), "error", "click");
                verifierPseudoIncorrecte(pseudosJoueurs, iJoueur);
            } while (pseudosJoueurs[iJoueur].isEmpty() || pseudosJoueurs[iJoueur].length() > 16 || pseudosJoueurs[iJoueur].contains(" ") || Logique.elementExisteDansTableauString(pseudosJoueurs, pseudosJoueurs[iJoueur], iJoueur));
        }
    }

    public static void verifierPseudoIncorrecte(String[] pseudosJoueurs, int iJoueur) {
        if (pseudosJoueurs[iJoueur].isEmpty()) {
            Affichage.afficherMessageErreur("Ce pseudo est vide !");
        } else if (pseudosJoueurs[iJoueur].length() > 16 && pseudosJoueurs[iJoueur].contains(" ")) {
            Affichage.afficherMessageErreur("Ce pseudo contient un espace et plus de 16 caractères !");
        } else if (pseudosJoueurs[iJoueur].length() > 16) {
            Affichage.afficherMessageErreur("Ce pseudo contient plus de 16 caractères !");
        } else if (pseudosJoueurs[iJoueur].contains(" ")) {
            Affichage.afficherMessageErreur("Ce pseudo contient un espace !");
        } else if (Logique.elementExisteDansTableauString(pseudosJoueurs, pseudosJoueurs[iJoueur], iJoueur)) {
            Affichage.afficherMessageErreur("Un autre joueur possède ce pseudo !");
        }
    }
}