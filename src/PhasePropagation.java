import java.util.Scanner;

public class PhasePropagation {
    public static final int[][][][] propagationDesCartes = {
            { // CARTE 1
                    { // POSSIBILITE 1
                            {0, 0, 0, 0, 0},
                            {8, 0, 0, 0, 0},
                            {0, 2, 7, 0, 0},
                            {0, 1, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 8, 0, 0},
                            {0, 0, 0, 2, 7},
                            {0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 2
                    { // POSSIBILITE 1
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 2, 8},
                            {0, 0, 9, 1, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 2, 8, 0, 0},
                            {9, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 3
                    {
                            {0, 0, 0, 6, 0},
                            {0, 0, 0, 2, 0},
                            {0, 0, 9, 1, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 4
                    {
                            {0, 0, 9, 0, 0},
                            {0, 0, 0, 2, 0},
                            {0, 0, 0, 1, 0},
                            {0, 0, 0, 5, 0}
                    }
            },
            { // CARTE 5
                    {
                            {0, 0, 0, 6, 0},
                            {0, 0, 0, 2, 0},
                            {0, 0, 0, 1, 0},
                            {0, 0, 0, 5, 0}
                    }
            },
            { // CARTE 6
                    {
                            {0, 0, 8, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 2, 8, 0, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 7
                    { // POSSIBILITE 1
                            {0, 0, 3, 0, 0},
                            {0, 0, 0, 2, 8},
                            {0, 0, 0, 6, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 0, 0, 0},
                            {3, 0, 0, 0, 0},
                            {0, 2, 8, 0, 0},
                            {0, 6, 0, 0, 0}
                    }
            },
            { // CARTE 8
                    { // POSSIBILITE 1
                            {0, 7, 8, 0, 0},
                            {3, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 7, 8},
                            {0, 0, 3, 1, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 9
                    { // POSSIBILITE 1
                            {0, 0, 9, 1, 0},
                            {0, 0, 0, 2, 0},
                            {0, 0, 0, 4, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 0, 0, 0},
                            {9, 1, 0, 0, 0},
                            {0, 2, 0, 0, 0},
                            {0, 4, 0, 0, 0}
                    }
            },
            { // CARTE 10
                    { // POSSIBILITE 1
                            {0, 2, 8, 0, 0},
                            {0, 1, 0, 0, 0},
                            {0, 5, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 2, 8},
                            {0, 0, 0, 1, 0},
                            {0, 0, 0, 5, 0}
                    }
            },
            { // CARTE 11
                    { // POSSIBILITE 1
                            {0, 2, 8, 0, 0},
                            {0, 1, 0, 5, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 2, 8, 0, 0},
                            {0, 1, 0, 5, 0}
                    }
            },
            { // CARTE 12
                    { // POSSIBILITE 1
                            {0, 2, 8, 6, 0},
                            {0, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    },
                    { // POSSIBILITE 2
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 2, 8, 6, 0},
                            {0, 1, 0, 0, 0}
                    }
            },
            { // CARTE 13
                    {
                            {0, 0, 3, 0, 0},
                            {0, 1, 0, 5, 8},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 14
                    {
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 8},
                            {0, 2, 3, 6, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 15
                    {
                            {0, 0, 0, 0, 0},
                            {3, 0, 0, 0, 0},
                            {0, 2, 8, 0, 0},
                            {0, 0, 0, 5, 0}
                    }
            },
            { // CARTE 16
                    {
                            {0, 0, 8, 6, 0},
                            {3, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 17
                    {
                            {0, 0, 0, 0, 0},
                            {3, 0, 0, 0, 0},
                            {0, 2, 8, 6, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 18
                    {
                            {0, 0, 8, 0, 0},
                            {3, 1, 0, 5, 0},
                            {0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 19
                    {
                            {0, 0, 3, 0, 0},
                            {0, 0, 0, 2, 0},
                            {0, 0, 9, 4, 0},
                            {0, 0, 0, 0, 0}
                    }
            },
            { // CARTE 20
                    {
                            {0, 0, 9, 0, 0},
                            {0, 0, 0, 7, 0},
                            {0, 0, 3, 1, 0},
                            {0, 0, 0, 0, 0}
                    }
            }
    };

    /// Dans cette partie du code, on va mettre les fonctions qui vont permettre le bon déroulé de la phase de propagation

    // Initialisation globale du scanner
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    /**
     * Extraction d'un sous-tableau du plateau 3D selon les choix et indices.
     * @param plateau Le plateau principal
     * @param choix Le choix du joueur pour la région
     * @param midY Milieu vertical
     * @param midX Milieu horizontal
     * @return Sous-tableau correspondant à la région choisie
     */
    static int[][][] extraireSousTableau(int[][][] plateau, String choix, int midY, int midX) {
        int startX = choix.contains("droite") ? midX : 0;
        int startY = choix.contains("bas") ? midY : 0;
        int endX = choix.contains("droite") ? plateau[0].length : midX;
        int endY = choix.contains("bas") ? plateau.length : midY;

        int[][][] sousTableau = new int[endY - startY][endX - startX][plateau[0][0].length];
        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                sousTableau[y - startY][x - startX] = plateau[y][x].clone();
            }
        }
        return sousTableau;
    }

    /**
     * Transforme une case spécifique dans le plateau 3D en un tableau 2D.
     * @param plateau Plateau 3D contenant les données
     * @param ligne Position verticale de la case ciblée
     * @param colonne Position horizontale de la case ciblée
     * @return Un tableau 2D de dimensions 4x5
     */
    public static int[][] transformerCaseEnTableau(int[][][] plateau, int ligne, int colonne) {
        int[][] res = new int[4][5];

        if (colonne == 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 5; j++) {
                    if (!(i == 3 && (j == 0 || j == 4))) {
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            // On met la couleur + 1, donc en gros si c'est un 1 y a pas de couleurs, sinon il y en a une
                            res[i][j] = plateau[ligne + i][colonne - 2 + j][1] + 1;
                        }
                    }
                }
            }
        } else if (colonne == 13) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!(i == 3 && (j == 0 || j == 4))) {
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            res[i][j] = plateau[ligne + i][colonne - 2 + j][1] + 1;
                        }
                    }
                }
            }
        } else if (ligne == 10) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                        res[i][j] = plateau[ligne + i][colonne - 2 + j][1] + 1;
                    }
                }
            }
        } else if (colonne > 1 && colonne < 13) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if (!(i == 3 && (j == 0 || j == 4))) {
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            res[i][j] = plateau[ligne + i][colonne - 2 + j][1] + 1;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * Vérifie si une propagation est possible pour un joueur donné.
     * Effectue aussi des actions selon les choix de l'utilisateur.
     * @param plateau Plateau 3D contenant les données
     * @param ligne Position verticale de la case à vérifier
     * @param colonne Position horizontale de la case à vérifier
     * @param iJoueur Indice du joueur actif
     * @param victimesJoueurs Tableau des victimes par joueur
     * @param carteSpecific Liste des configurations possibles de propagation
     * @return true si la propagation est confirmée, sinon false
     */
    public static boolean verificationPropagation(int[][][] plateau, int ligne, int colonne, int iJoueur, int[] victimesJoueurs, int[][][] carteSpecific) {
        // Transformer la case en tableau via la méthode existante
        int[][] tableauCase = transformerCaseEnTableau(plateau, ligne, colonne);

        String choix1 = "";
        int choix2 = 0;

        if (carteSpecific.length == 1 && verifierSourcesValides(tableauCase, carteSpecific[0], iJoueur)) {
            Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
        //if (carteSpecific.length == 1 && sontSimilaires2(plateau, tableauCase, carteSpecific[0], iJoueur, ligne, colonne)) {
            // Il n'y a qu'une possibilite possible
            Affichage.afficherCase(plateau, ligne, colonne, carteSpecific[0], tableauCase);
            System.out.println();
            do {
                choix1 = Affichage.saisirChaine(Affichage.VERT + "Êtes vous sûr de jouer sur cette case ? (o/n) : " + Affichage.RESET);
                Audio.jouerSonSaisie(!(choix1.equalsIgnoreCase("o") || choix1.equalsIgnoreCase("n")), "error", "click");
            } while (!(choix1.equalsIgnoreCase("o") || choix1.equalsIgnoreCase("n")));
            if (choix1.equalsIgnoreCase("o")) {
                modifierPropagationTableau(plateau, ligne, colonne, carteSpecific[0], iJoueur);
                analyserContoursCase(plateau, ligne, colonne, iJoueur, victimesJoueurs, true, 0);
            }
        } else if (carteSpecific.length == 2) {
            if (verifierSourcesValides(tableauCase, carteSpecific[0], iJoueur) && verifierSourcesValides(tableauCase, carteSpecific[1], iJoueur)) {
                Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
            //if (sontSimilaires2(plateau, tableauCase, carteSpecific[0], iJoueur, ligne, colonne) && sontSimilaires2(plateau, tableauCase, carteSpecific[1], iJoueur, ligne, colonne)) {
                // Les deux possibilites sont possibles
                System.out.println("2 possibilités : ");
                Affichage.afficherCase(plateau, ligne, colonne, carteSpecific[0], tableauCase);
                System.out.println();
                Affichage.afficherCase(plateau, ligne, colonne, carteSpecific[1], tableauCase);
                System.out.println();
                System.out.println("1. Appliquer la première possibilité");
                System.out.println("2. Appliquer le deuxième possibilité");
                System.out.println("3. Retour au plateau");
                do {
                    choix2 = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
                    Audio.jouerSonSaisie(choix2 < 1 || choix2 > 3, "error", "click");
                } while (choix2 < 1 || choix2 > 3);
                if (choix2 == 1) { // Apliquer la premiere possbilite
                    modifierPropagationTableau(plateau, ligne, colonne, carteSpecific[0], iJoueur);
                    analyserContoursCase(plateau, ligne, colonne, iJoueur, victimesJoueurs, true, 0);
                } else if (choix2 == 2) { // Aplliquer la deuxieme possibilite
                    modifierPropagationTableau(plateau, ligne, colonne, carteSpecific[1], iJoueur);
                    analyserContoursCase(plateau, ligne, colonne, iJoueur, victimesJoueurs, true, 0);
                }
            } else if ((verifierSourcesValides(tableauCase, carteSpecific[0], iJoueur) && /*ARRAY ->*/ !verifierSourcesValides(tableauCase, carteSpecific[1], iJoueur)) || (!verifierSourcesValides(tableauCase, carteSpecific[0], iJoueur) && /*ARRAY ->*/ verifierSourcesValides(tableauCase, carteSpecific[1], iJoueur))) {
                Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
                int[][] carteValide;

                // L'une des deux possibilites est possible
                if (verifierSourcesValides(tableauCase, carteSpecific[0], iJoueur)) {
                //if (sontSimilaires2(plateau, tableauCase, carteSpecific[0], iJoueur, ligne, colonne)) {
                    carteValide = carteSpecific[0];
                    Affichage.afficherCase(plateau, ligne, colonne, carteValide, tableauCase);
                } else {
                    carteValide = carteSpecific[1];
                    Affichage.afficherCase(plateau, ligne, colonne, carteValide, tableauCase);
                }
                do {
                    choix1 = Affichage.saisirChaine(Affichage.VERT + "Êtes vous sûr de jouer sur cette case ? (o/n) : " + Affichage.RESET);
                    Audio.jouerSonSaisie(!(choix1.equalsIgnoreCase("o") || choix1.equalsIgnoreCase("n")), "error", "click");
                } while (!(choix1.equalsIgnoreCase("o") || choix1.equalsIgnoreCase("n")));
                if (choix1.equalsIgnoreCase("o")) {
                    modifierPropagationTableau(plateau, ligne, colonne, carteValide, iJoueur);
                    analyserContoursCase(plateau, ligne, colonne, iJoueur, victimesJoueurs, true, 0);
                }
            }
        }

        if (choix1.equalsIgnoreCase("o") || (choix2 >= 1 && choix2 <= 2)) {
            return true;
        } else {
            // Si il s'agit d'une case injouable et pas d'un retour
            if (!(choix1.equalsIgnoreCase("n") || choix2 == 3)) {
                Audio.jouerAudio("assets/audio/error.wav", 80, false, Parametres.effetsSonores);
                Affichage.afficherMessageErreur("Vous ne pouvez pas jouer sur cette case !");
            }
            return false;
        }
    }

    /**
     * Compare deux tableaux (case et carte propagation) pour vérifier leur similarité.
     * @param donneesCase Le tableau représentant les données actuelles de la case
     * @param donneesCarte La représentation de la carte de propagation ciblée
     * @param iJoueur Indice du joueur
     * @return true si les deux tableaux sont similaires, sinon false
     */
    public static boolean verifierSourcesValides(int[][] donneesCase, int[][] donneesCarte, int iJoueur) {
        int cptSourceValides = 0;

        for (int i = 0; i < donneesCarte.length; i++) {
            for (int j = 0; j < donneesCarte[i].length; j++) {
                // On check que les sources et les 1 de la case correspondent
                if (donneesCarte[i][j] >= 1 && donneesCarte[i][j] <= 3) {
                    // Si c'est un 1 (il n'y a pas de couleur) ou que c'est x (la couleur du joueur qui joue)
                    if (donneesCase[i][j] == 1 || donneesCase[i][j] == iJoueur + 2) { // + 2 parce qu'il y a 1 qui correspond au debut du compatge pour la case, et un second 1 qui correspond a la couleur
                        cptSourceValides++;
                    }
                }
            }
        }

        return cptSourceValides == 2;
    }

    /**
     * Applique une propagation à la case ciblée dans le plateau 3D.
     * @param plateau Plateau 3D contenant les données actuelles
     * @param ligne Position verticale de la case ciblée
     * @param colonne Position horizontale de la case ciblée
     * @param cartePropagation Configuration de la propagation à appliquer
     * @param iJoueur Indice du joueur effectuant l'action
     */
    public static void modifierPropagationTableau(int[][][] plateau, int ligne, int colonne, int[][] cartePropagation, int iJoueur) {
        // Chaque ligne de la carte
        for (int i = 0; i < cartePropagation.length; i++) {
            // Chaque colonne et donc valeur de la carte
            for (int j = 0; j < cartePropagation[i].length; j++) {
                // Si la valeur n'est pas 0, donc qu'il y a une donnee dans la carte de propagation
                if (cartePropagation[i][j] > 0) {
                    // Cas ou l'on va ignorer ou laisser des trucs j'ai pas tres bien compris
                    if (colonne == 1 && j != 0) {
                        // Si la case ATT QUOI ???
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            plateau[ligne + i][colonne - 2 + j][1] = iJoueur + 1;
                        }
                    } else if (colonne == 13 && j != 4) {
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            plateau[ligne + i][colonne - 2 + j][1] = iJoueur + 1;
                        }
                    } else if (ligne == 10 && i != 3) {
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            plateau[ligne + i][colonne - 2 + j][1] = iJoueur + 1;
                        }
                    } else if (colonne > 1 && colonne < 13 && ligne < 10) {
                        // Si il s'agit d'un chemin
                        // En gros c'est pour savoir si
                        if (plateau[ligne + i][colonne - 2 + j][0] == 1) {
                            plateau[ligne + i][colonne - 2 + j][1] = iJoueur + 1;
                        }
                    }
                }
            }
        }
    }

    /**
     * Analyse les contours d'une case pour appliquer des effets spécifiques
     * selon les règles de jeu (comme l'ajustement des victimes, par exemple).
     * @param plateau Plateau 3D contenant les données globales
     * @param ligne Position verticale de la case ciblée
     * @param colonne Position horizontale de la case ciblée
     * @param iJoueur Indice du joueur actif
     * @param victimesJoueurs Tableau des victimes par joueur
     */
    public static int analyserContoursCase(int[][][] plateau, int ligne, int colonne, int iJoueur, int[] victimesJoueurs, boolean origine, int nbVictimesEnchaine) {
        int cptContours = 0;
        int[][] tableauCase = transformerCaseEnTableau(plateau, ligne, colonne);

        if (plateau[ligne + 1][colonne][2] > 0) { // Si il n'est pas deja mort / qu'il y a des kills a recup
            for (int i = 0; i < tableauCase.length - 1; i++) {
                for (int j = 1; j < tableauCase[i].length - 1; j++) {
                    if (!(i == 0 && (j == 1 || j == 3))) {
                        if (tableauCase[i][j] > 1) {
                            cptContours++;
                        }
                    }
                }
            }
        }

        // Si c'est la case d'origine, on analyse les cases voisines en indiquant qu'elle ne sont pas origines pour ne pas entré dans une boucle infinies
        if (origine) {
            // La dcp ligne et colonne vont changer selon la ou on est dans le plateau
            // Faire les 10000 if pour check les extremités
            // Je devrai en faire une fonction tlm on l'utilise souvent enft
            if (colonne == 1) {
                if (plateau[ligne - 1][colonne][0] == 2 && plateau[ligne - 1][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne + 2][0] == 2 && plateau[ligne][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne + 2][0] == 2 && plateau[ligne + 2][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 3][colonne][0] == 2 && plateau[ligne + 3][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            } else if (colonne == 13) {
                if (plateau[ligne - 1][colonne][0] == 2 && plateau[ligne - 1][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne - 2][0] == 2 && plateau[ligne][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne - 2][0] == 2 && plateau[ligne + 2][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 3][colonne][0] == 2 && plateau[ligne + 3][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            } else if (ligne == 0) {
                if (plateau[ligne + 2][colonne - 2][0] == 2 && plateau[ligne + 2][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 3][colonne][0] == 2 && plateau[ligne + 3][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne + 2][0] == 2 && plateau[ligne + 2][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            } else if (ligne == 10) {
                if (plateau[ligne - 1][colonne - 2][0] == 2 && plateau[ligne - 1][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne - 2][colonne][0] == 2 && plateau[ligne - 2][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne - 1][colonne + 2][0] == 2 && plateau[ligne - 1][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            } else if (ligne == 1) {
                if (plateau[ligne][colonne - 2][0] == 2 && plateau[ligne][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne - 2][0] == 2 && plateau[ligne + 2][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 3][colonne][0] == 2 && plateau[ligne + 3][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne + 2][0] == 2 && plateau[ligne + 2][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne + 2][0] == 2 && plateau[ligne][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            } else if (ligne == 9) {
                if (plateau[ligne + 2][colonne - 2][0] == 2 && plateau[ligne + 2][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne - 2][0] == 2 && plateau[ligne][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne - 2][colonne][0] == 2 && plateau[ligne - 2][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne + 2][0] == 2 && plateau[ligne][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne + 2][0] == 2 && plateau[ligne + 2][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            } else {
                if (plateau[ligne - 1][colonne][0] == 2 && plateau[ligne - 1][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne - 2][0] == 2 && plateau[ligne][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne - 2][colonne - 2][0] == 2 && plateau[ligne - 2][colonne - 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne - 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 3][colonne][0] == 2 && plateau[ligne + 3][colonne][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 2, colonne, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne + 2][colonne + 2][0] == 2 && plateau[ligne + 2][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne + 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                } if (plateau[ligne][colonne + 2][0] == 2 && plateau[ligne][colonne + 2][2] != 0) {
                    nbVictimesEnchaine += analyserContoursCase(plateau, ligne - 1, colonne + 2, iJoueur, victimesJoueurs, false, nbVictimesEnchaine);
                }
            }
        }

        if (cptContours == 6) { // 6 correspond au nombre de chemins qui entoure une case pour etre tué
            victimesJoueurs[iJoueur] += plateau[ligne + 1][colonne][2];
            plateau[ligne + 1][colonne][2] = 0;
            nbVictimesEnchaine++;
        }

        // Il y a certains cas ou les sons ne sont pas joué ? Peut être parce que certaines tuiles voisines sont deja mortes ???
        /*if (origine) {
            switch (nbVictimesEnchaine) {
                case 1 -> Audio.jouerAudio("assets/audio/kill.wav", 70, false, Parametres.effetsSonores);
                case 2 -> Audio.jouerAudio("assets/audio/double_kill.wav", 70, false, Parametres.effetsSonores);
                case 3 -> Audio.jouerAudio("assets/audio/triple_kill.wav", 70, false, Parametres.effetsSonores);
            }
        }*/
        if (origine && nbVictimesEnchaine > 0) {
            Audio.jouerAudio("assets/audio/kill.wav", 70, false, Parametres.effetsSonores);
        }

        // Si on tue la atuelle le son se joue correctmement
        // Si on tue la case actuelle + une case voisine le son se joue correctement
        // Par contre si on tue juste une case voisine il y a un probleme de son
        // Il y a un probleme de verification au debut, qui peut affecter le nb de victimes

        return nbVictimesEnchaine;
    }
}
