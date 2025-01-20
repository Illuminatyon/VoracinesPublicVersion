import java.util.ArrayList;
import java.util.Arrays;

/* TODO PROBLEME au niveau de l'affichage des couleurs lorsqu'on affiche le pseudo du joueur */

public class Jeu {

    public static String[] couleursJoueurs;

    /**
     * Lance la partie en considérant que nous ne sommes pas dans le cas d'un 2c2.
     *
     * @param nbJoueurs
     */
    public static void lancerPartie(int nbJoueurs) {
        lancerPartie(nbJoueurs, false);
    }

    /**
     * Lance une partie de jeu pour un nombre spécifié de joueurs, avec une option pour jouer en mode 2 contre 2.
     * Cette fonction gère toutes les étapes importantes du jeu : l'initialisation des pseudos,
     * la mise en place du plateau, la gestion des cartes des joueurs et les différentes phases de jeu.
     *
     * @param nbJoueurs   Le nombre total de joueurs dans la partie.
     * @param jouerEn2c2  Un booléen indiquant si le mode 2 contre 2 est activé :
     *                    - `true` : les joueurs seront organisés en équipes (coéquipiers).
     *                    - `false` : chaque joueur joue de manière individuelle.
     */
    public static void lancerPartie(int nbJoueurs, boolean jouerEn2c2) {
        String[] pseudosJoueurs = new String[nbJoueurs];
        int[] victimesJoueurs = new int[nbJoueurs];

        for (int i = 0; i < nbJoueurs; i++) {
            GestionJoueur.affecterPseudoJoueur(pseudosJoueurs, i, jouerEn2c2);
        }

        //Affichage.nettoyerConsole(200);

        int[][][] plateau = {
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 0, 2}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 0, 2}, {1, 0, 0}, {0, 0, 0}, {1, 0, 1}, {1, 0, 2}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 0, 2}, {1, 0, 0}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 1}, {1, 0, 2}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0}, {1, 0, 2}, {1, 0, 0}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 1}, {1, 0, 2}, {0, 0, 0}},
                {{1, 0, 0}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 1}},
                {{1, 0, 1}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {2, 3, 15}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 0}},
                {{1, 0, 0}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {2, 3, 15}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {2, 3, 15}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 1}},
                {{1, 0, 1}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {2, 3, 15}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 0}},
                {{1, 0, 0}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 1}},
                {{1, 0, 1}, {1, 0, 2}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 2}, {1, 0, 0}},
                {{0, 0, 0}, {0, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 5}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 2}, {1, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}, {0, 0, 0}, {1, 0, 4}, {1, 0, 2}, {1, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
        };

        // I. Mise en place du jeu
        // Mise en place du plateau

        MiseEnPlace.remplirCouche(plateau, 2, 5, 1);
        MiseEnPlace.remplirCouche(plateau, 1, 4, 2);

        // Mise en place des couleurs des joueurs
        couleursJoueurs = new String[nbJoueurs];
        ArrayList<String> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.addAll(Arrays.asList(GestionJoueur.couleurs));
        for (int i = 0; i < nbJoueurs; i++) {
            GestionJoueur.proposerCouleurs(couleursDisponibles, couleursJoueurs, i, pseudosJoueurs[i]);
        }

        // Mise en place de la pile de propagation
        ArrayList<Integer> pilePropagation = MiseEnPlace.initialiserPileAleatoirement();




        // Tant qu'il n'y a pas un joueur qui a atteint l'objectif
        while (!Logique.objectifAtteintJoueurs(nbJoueurs, victimesJoueurs, jouerEn2c2)) {
            // II. Phase de planification

            // Chaque joueur pioche 4 cartes
            ArrayList<Integer>[] filesJoueurs = new ArrayList[nbJoueurs];
            Logique.attendre(500);

            Affichage.nettoyerConsole(200);
            System.out.print("Chaque joueur obtient 4 cartes");
            for (int i = 0; i < nbJoueurs; i++) {
                filesJoueurs[i] = Logique.piocherPile(pilePropagation, 4);
                for (int j = 0; j < 4; j++) {
                    Audio.jouerAudio("assets/audio/DistributionUneCarte.wav", 90, false, Parametres.effetsSonores);
                    Logique.attendre(100);
                }
                Logique.attendre(100);
                // Mettre avec cette attente une limite de temps ou si le joueur
                // n'as pas choisi quel carte defausser, une des carte sera defausser aleatoirement
            }
            Logique.attendre(500);

            Affichage.nettoyerConsole(200);

            // Les joueurs doivent chacun à leur tour choisir une carte à défausser
            for (int iJoueur = 0; iJoueur < nbJoueurs; iJoueur++) {
                int choixCarteADefausser;

                System.out.println("Seul(e) " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iJoueur])] + Affichage.GRAS + pseudosJoueurs[iJoueur] + Affichage.RESET + " peut regarder l'écran !");
                Logique.viderBuffer();
                Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée dès que vous êtes prêt à voir vos cartes" + Affichage.RESET);

                do {
                    Affichage.nettoyerConsole(200);
                    System.out.println("Seul(e) " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iJoueur])] + Affichage.GRAS + pseudosJoueurs[iJoueur] + Affichage.RESET + " peut regarder l'écran !");
                    // Affiche chaque carte de la file du joueur iJoueur
                    choixCarteADefausser = PhasePlanification.demanderDefausseJoueur(filesJoueurs[iJoueur]);
                } while (!(filesJoueurs[iJoueur].contains(choixCarteADefausser)));

                // Défausse de le carte choisie avec un rappel
                Logique.defausser(pilePropagation, filesJoueurs[iJoueur], Logique.trouverIndiceCarte(filesJoueurs[iJoueur], choixCarteADefausser));
                System.out.print("Vous avez défaussé la carte " + choixCarteADefausser + " !");

                Audio.jouerAudio("assets/audio/DistributionUneCarte.wav", 90, false, Parametres.effetsSonores);
                Logique.attendre(1000);

                Affichage.nettoyerConsole(200);
            }

            // Changer l'ordre de la file pour chaque joueur
            int choixCarteADeplacer1, choixCarteADeplacer2;

            for (int i = 0; i < nbJoueurs; i++) {
                boolean confirmationModificationOrdre = false;
                String choixConfirmation;
                String messageChoixConfirmation;

                System.out.println("Modification de l'ordre des cartes");
                System.out.println();
                System.out.println("Seul(e) " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[i])] + Affichage.GRAS + pseudosJoueurs[i] + Affichage.RESET + " peut regarder l'écran !");
                Logique.viderBuffer();
                Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée dès que vous êtes prêt à voir vos cartes" + Affichage.RESET);

                // Demande au joueur si il souhaite effectuer un premier changement d'ordre
                do {
                    messageChoixConfirmation = "Souhaitez-vous modifier l'ordre ? (o/n) : ";
                    JcJ.afficherModificationOrdreCartes(nbJoueurs, messageChoixConfirmation, couleursJoueurs, pseudosJoueurs, filesJoueurs, i);
                    Logique.viderBuffer();
                    choixConfirmation = Affichage.saisirChaine(Affichage.VERT + messageChoixConfirmation + Affichage.RESET);
                    //Audio.jouerSonSaisie(!choixConfirmation.equalsIgnoreCase("o") && !choixConfirmation.equalsIgnoreCase("n"), "error", "click");
                } while (!choixConfirmation.equalsIgnoreCase("o") && !choixConfirmation.equalsIgnoreCase("n"));

                // Tant que le joueur n'a pas confirmé qu'il a terminé le changement d'ordre
                while (!confirmationModificationOrdre) {
                    if (choixConfirmation.equalsIgnoreCase("n")) {
                        confirmationModificationOrdre = true;
                        Affichage.nettoyerConsole(200);
                    } else if (choixConfirmation.equalsIgnoreCase("o")) {
                        // Demander la saisie de la premiere carte
                        do {
                            JcJ.afficherModificationOrdreCartes(nbJoueurs, messageChoixConfirmation, couleursJoueurs, pseudosJoueurs, filesJoueurs, i);
                            System.out.println(Affichage.VERT + messageChoixConfirmation + choixConfirmation + Affichage.RESET);
                            System.out.println("Si vous ne voulez finalement pas changer l'ordre, échanger une carte avec elle même");
                            Logique.viderBuffer();
                            choixCarteADeplacer1 = Affichage.saisirEntier(Affichage.VERT + "Saisissez le numéro de la carte à déplacer : " + Affichage.RESET);
                        } while (!(filesJoueurs[i].contains(choixCarteADeplacer1)));

                        // Demander la saisie de la deuxieme carte
                        do {
                            JcJ.afficherModificationOrdreCartes(nbJoueurs, messageChoixConfirmation, couleursJoueurs, pseudosJoueurs, filesJoueurs, i);
                            System.out.println(Affichage.VERT + messageChoixConfirmation + choixConfirmation + Affichage.RESET);
                            System.out.println("Si vous ne voulez finalement pas changer l'ordre, échanger une carte avec elle même");
                            System.out.println(Affichage.VERT + "Saisissez le numéro de la carte à déplacer : " + choixCarteADeplacer1 + Affichage.RESET);
                            Logique.viderBuffer();
                            choixCarteADeplacer2 = Affichage.saisirEntier(Affichage.VERT + "Saisissez le numéro de la carte avec laquelle échanger l'emplacement : " + Affichage.RESET);
                        } while (!(filesJoueurs[i].contains(choixCarteADeplacer2)));

                        GestionJoueur.modifierOrdreFile(filesJoueurs[i], Logique.trouverIndiceCarte(filesJoueurs[i], choixCarteADeplacer1), Logique.trouverIndiceCarte(filesJoueurs[i], choixCarteADeplacer2));
                        // On pourrai jouer un audio, mais ca indiquerai aux autre joueurs que le joueur actuelles a fait un changement

                        // Demande de confirmation pour savoir s'il veut effectuer plus de changement ou non
                        do {
                            JcJ.afficherModificationOrdreCartes(nbJoueurs, messageChoixConfirmation, couleursJoueurs, pseudosJoueurs, filesJoueurs, i);
                            System.out.println(Affichage.VERT + messageChoixConfirmation + choixConfirmation + Affichage.RESET);
                            System.out.println("Si vous ne voulez finalement pas changer l'ordre, échanger une carte avec elle même");
                            System.out.println(Affichage.VERT + "Saisissez le numéro de la carte à déplacer : " + choixCarteADeplacer1 + Affichage.RESET);
                            System.out.println(Affichage.VERT + "Saisissez le numéro de la carte avec laquelle échanger l'emplacement : " + choixCarteADeplacer2 + Affichage.RESET);
                            Logique.viderBuffer();
                            choixConfirmation = Affichage.saisirChaine(Affichage.VERT + "Voulez vous effectuer des changement supplémentaires ? (o/n) : " + Affichage.RESET);
                            if (choixConfirmation.equalsIgnoreCase("o")) {
                                messageChoixConfirmation = "Voulez vous effectuer des changement supplémentaires ? (o/n) : ";
                            }
                        } while (!choixConfirmation.equalsIgnoreCase("o") && !choixConfirmation.equalsIgnoreCase("n"));
                    }
                }
            }



            // Tant que les joueurs ont encore des cartes
            while (!Logique.filesVides(filesJoueurs, nbJoueurs) && !Logique.objectifAtteintJoueurs(nbJoueurs, victimesJoueurs, jouerEn2c2)) {
                Affichage.nettoyerConsole(200);
                // III. Phase de propagation
                ArrayList<Integer> premieresCartes = new ArrayList<Integer>();

                // Tous les joueurs revelent simultanement leur premiere carte
                for (int i = 0; i < nbJoueurs; i++) {
                    premieresCartes.add(filesJoueurs[i].getFirst());
                    System.out.println("Première carte de " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[i])] + Affichage.GRAS + pseudosJoueurs[i] + Affichage.RESET);
                    System.out.println(Affichage.cartesPropagation[premieresCartes.get(i) - 1]);
                    System.out.println();
                }

                System.out.println();
                Logique.viderBuffer();
                Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée pour continuer" + Affichage.RESET);
                Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);

                // Fais jouer chaque joueur leur premiere carte
                int iJoueur = 0;
                while (iJoueur < nbJoueurs && !Logique.objectifAtteintJoueurs(nbJoueurs, victimesJoueurs, jouerEn2c2)) {
                    int[] iJoueurQuiJoueDansLOrdreCroissantDesCartes = Logique.triABulles(premieresCartes);
                    String choixProp;
                    boolean conditionErreurChoixProp = false;

                    String[] casesValides = {
                            "A4",
                            "B3", "B5",
                            "C2", "C4", "C6",
                            "D1", "D3", "D5", "D7",
                            "E2", "E4", "E6",
                            "F1", "F3", "F5", "F7",
                            "G2", "G4", "G6",
                            "H1", "H3", "H5", "H7",
                            "I2", "I4", "I6",
                            "J3", "J5",
                            "K4"
                    };

                    do {
                        Affichage.nettoyerConsole(200);
                        Affichage.afficherScores(victimesJoueurs, pseudosJoueurs, couleursJoueurs);
                        System.out.println();
                        Affichage.afficherPlateau(plateau);
                        System.out.println();
                        System.out.println(Affichage.cartesPropagation[premieresCartes.get(iJoueurQuiJoueDansLOrdreCroissantDesCartes[iJoueur]) - 1]);
                        System.out.println("C'est " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iJoueurQuiJoueDansLOrdreCroissantDesCartes[iJoueur]])] + Affichage.GRAS + pseudosJoueurs[iJoueurQuiJoueDansLOrdreCroissantDesCartes[iJoueur]] + Affichage.RESET + " qui joue");
                        System.out.println();

                        Logique.viderBuffer();
                        choixProp = Affichage.saisirChaine(Affichage.VERT + "Saisissez où vous souhaitez jouer (ex: K4) : " + Affichage.RESET);
                        choixProp = choixProp.toUpperCase();

                        if (Logique.elementExisteDansTableauString(casesValides, choixProp)) {
                            int ligne = choixProp.charAt(0) - 'A';
                            int colonne = (choixProp.charAt(1) - '1' + 1) * 2 - 1;
                            conditionErreurChoixProp = !(plateau[ligne][colonne][0] == 1 && (plateau[ligne][colonne][2] == 2 || plateau[ligne][colonne][2] == 5));
                        } else {
                            // Si la chaîne ne fait pas 2 caractères
                            Audio.jouerAudio("assets/audio/error.wav", 80, false, Parametres.effetsSonores);
                            Affichage.afficherMessageErreur("Saisissez une case correcte !");
                            conditionErreurChoixProp = true; // Continuer de demander à l'utilisateur
                        }
                    } while (conditionErreurChoixProp);

                    if (PhasePropagation.verificationPropagation(plateau, choixProp.charAt(0) - 'A', (choixProp.charAt(1) - '1' + 1) * 2 - 1, iJoueurQuiJoueDansLOrdreCroissantDesCartes[iJoueur], victimesJoueurs, PhasePropagation.propagationDesCartes[filesJoueurs[iJoueurQuiJoueDansLOrdreCroissantDesCartes[iJoueur]].getFirst() - 1])) {
                        // Retirer de la file du joueur qui a joué sa carte
                        Logique.defausser(pilePropagation, filesJoueurs[iJoueurQuiJoueDansLOrdreCroissantDesCartes[iJoueur]], 0);
                        iJoueur++;
                    }
                }

                Affichage.nettoyerConsole(200);
                Affichage.afficherScores(victimesJoueurs, pseudosJoueurs, couleursJoueurs);
                System.out.println();
                System.out.println("Voici l'état actuel du plateau :");
                System.out.println();
                Affichage.afficherPlateau(plateau);
                System.out.println();
                Logique.viderBuffer();
                Affichage.saisirChaine(Affichage.VERT + "Appuyez sur entrée pour continuer" + Affichage.RESET);
                Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
            }
        }

        // On va voir c'est quel joueur qui a le plus de victimes
        if (!jouerEn2c2) {
            int vMax = 0;
            int iMax = 0;
            for (int i = 0; i < nbJoueurs; i++) {
                if (victimesJoueurs[i] > vMax) {
                    vMax = victimesJoueurs[i];
                    iMax = i;
                }
            }
            System.out.println("C'est " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iMax])] + Affichage.GRAS + pseudosJoueurs[iMax] + Affichage.RESET + " qui a gagné la partie avec " + vMax + " victimes !");
        } else {
            int vMax = 0;
            int iMax = 0;
            for (int i = 0; i < nbJoueurs; i += 2) {
                if (victimesJoueurs[i] > vMax) {
                    vMax = victimesJoueurs[i] + victimesJoueurs[i + 1];
                    iMax = i;
                }
            }
            System.out.println("Ce sont " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iMax])] + Affichage.GRAS + pseudosJoueurs[iMax] + Affichage.RESET + " et " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iMax + 1])] + Affichage.GRAS + pseudosJoueurs[iMax + 1] + Affichage.RESET + " qui gagnent la partie avec " + vMax + " victimes !");
        }
        Logique.attendre(2500);
        Logique.viderBuffer();
        Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée pour revenir au menu principal" + Affichage.RESET);
    }
}