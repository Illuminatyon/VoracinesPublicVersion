import java.util.ArrayList;
/**
 * La classe `MiseEnPlace` est responsable de la gestion de la configuration initiale et aléatoire des éléments
 * sur le plateau de jeu. Elle inclut la méthode `remplirCouche` qui permet de remplir une couche spécifique du
 * plateau avec des chaumières et d'autres éléments selon des règles définies, ainsi qu'une méthode pour initialiser
 * une pile de manière aléatoire.
 */
public class MiseEnPlace {

    /**
     * Remplie une couche spécifique du plateau avec des éléments en fonction des chaumières, autres éléments
     * et de la couche fournie.
     *
     * Cette méthode remplit le plateau en utilisant différentes formules pour placer des valeurs dans les cases du plateau
     * et affecte aléatoirement des chaumières et d'autres éléments dans certaines positions.
     *
     * @param plateau Le plateau de jeu sous forme de tableau tridimensionnel où les valeurs seront modifiées.
     * @param chaumiere Type de chaumière à placer sur le plateau (peut être 1 ou 2).
     * @param autre Type d'autre élément à placer sur le plateau (peut être 4 ou 5).
     * @param couche La couche à remplir (0, 1 ou 2).
     */
    public static void remplirCouche(int[][][] plateau, int chaumiere, int autre, int couche) {
        int alea;
        int nbChaumieres = -1;
        int nbAutre = -1;

        int nbVictimesChaumieres;

        // Verification pour la couche 2
        if (chaumiere == 1 && autre == 4 && couche == 2) {
            nbChaumieres = 10;
            nbAutre = 6; // Engrais
        }
        // Verification pour la couche 1
        else if (chaumiere == 2 && autre == 5 && couche == 1) {
            nbChaumieres = 6;
            nbAutre = 4; // Transmutation
        }
        nbVictimesChaumieres = 5 * chaumiere;

        if (couche == 1) {
            for (int i = 3; i <= 9; i++) {
                if (i == 3 || i == 9) { // Si c egal au premier i ou au dernier i
                    alea = (int) (Math.random() * 2);
                    plateau[i][7][0] = 2;
                    if (alea % 2 != 0 && nbChaumieres > 0) {
                        nbChaumieres = placerTuile(plateau, i, 7, chaumiere, nbVictimesChaumieres, nbChaumieres);
                    }
                    else if (alea % 2 == 0 && nbAutre > 0) {
                        nbAutre = placerTuile(plateau, i, 7, autre, 5, nbAutre);
                    }
                    else {
                        if (nbChaumieres > 0) {
                            nbChaumieres = placerTuile(plateau, i, 7, chaumiere, nbVictimesChaumieres, nbChaumieres);
                        } else if (nbAutre > 0) {
                            nbAutre = placerTuile(plateau, i, 7, autre, 5, nbAutre);
                        }
                    }
                } else if (i != 6) {
                    for (int j = 0; j < 2; j++) {
                        alea = (int) (Math.random() * 2);
                        if (i == 4 || i == 8) {
                            plateau[i][4 * j + 4 + 1][0] = 2;
                            if (alea % 2 != 0 && nbChaumieres > 0) {
                                nbChaumieres = placerTuile(plateau, i, 4 * j + 4 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                            } else if (alea % 2 == 0 && nbAutre > 0) {
                                nbAutre = placerTuile(plateau, i, 4 * j + 4 + 1, autre, 5, nbAutre);
                            } else {
                                if (nbChaumieres > 0) {
                                    nbChaumieres = placerTuile(plateau, i, 4 * j + 4 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                                } else if (nbAutre > 0) {
                                    nbAutre = placerTuile(plateau, i, 4 * j + 4 + 1, autre, 5, nbAutre);
                                }
                            }
                        } else if (i == 5 || i == 7) {
                            plateau[i][8 * j + 2 + 1][0] = 2;
                            if (alea % 2 != 0 && nbChaumieres > 0) {
                                nbChaumieres = placerTuile(plateau, i, 8 * j + 2 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                            } else if (alea % 2 == 0 && nbAutre > 0) {
                                nbAutre = placerTuile(plateau, i, 8 * j + 2 + 1, autre, 5, nbAutre);
                            } else {
                                if (nbChaumieres > 0) {
                                    nbChaumieres = placerTuile(plateau, i, 8 * j + 2 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                                } else if (nbAutre > 0) {
                                    nbAutre = placerTuile(plateau, i, 8 * j + 2 + 1, autre, 5, nbAutre);
                                }
                            }
                        }
                    }
                }
            }
        } else if (couche == 2) {
            for (int i = 1; i <= 11; i++) {
                if (i == 1 || i == 11) {
                    alea = (int) (Math.random() * 2);
                    plateau[i][7][0] = 2;
                    if (alea % 2 != 0 && nbChaumieres > 0) {
                        nbChaumieres = placerTuile(plateau, i, 7, chaumiere, nbVictimesChaumieres, nbChaumieres);
                    } else if (alea % 2 == 0 && nbAutre > 0) {
                        nbAutre = placerTuile(plateau, i, 7, autre, 5, nbAutre);
                    } else {
                        if (nbChaumieres > 0) {
                            nbChaumieres = placerTuile(plateau, i, 7, chaumiere, nbVictimesChaumieres, nbChaumieres);
                        } else if (nbAutre > 0) {
                            nbAutre = placerTuile(plateau, i, 7, autre, 5, nbAutre);
                        }
                    }
                } else if (i != 5 && i != 7) {
                    for (int j = 0; j < 2; j++) {
                        alea = (int) (Math.random() * 2);
                        if (i == 2 || i == 10) {
                            plateau[i][4 * j + 4 + 1][0] = 2;
                            if (alea % 2 != 0 && nbChaumieres > 0) {
                                nbChaumieres = placerTuile(plateau, i, 4 * j + 4 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                            } else if (alea % 2 == 0 && nbAutre > 0) {
                                nbChaumieres = placerTuile(plateau, i, 4 * j + 4 + 1, autre, 5, nbAutre);
                            } else {
                                if (nbChaumieres > 0) {
                                    nbChaumieres = placerTuile(plateau, i, 4 * j + 4 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                                } else if (nbAutre > 0) {
                                    nbAutre = placerTuile(plateau, i, 4 * j + 4 + 1, autre, 5, nbAutre);
                                }
                            }
                        } else if (i == 3 || i == 9) {
                            plateau[i][8 * j + 2 + 1][0] = 2;
                            if (alea % 2 != 0 && nbChaumieres > 0) {
                                nbChaumieres = placerTuile(plateau, i, 8 * j + 2 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                            } else if (alea % 2 == 0 && nbAutre > 0) {
                                nbAutre = placerTuile(plateau, i, 8 * j + 2 + 1, autre, 5, nbAutre);
                            } else {
                                if (nbChaumieres > 0) {
                                    nbChaumieres = placerTuile(plateau, i, 8 * j + 2 + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                                } else if (nbAutre > 0) {
                                    nbAutre = placerTuile(plateau, i, 8 * j + 2 + 1, autre, 5, nbAutre);
                                }
                            }
                        } else if (i == 4 || i == 6 || i == 8) {
                            plateau[i][12 * j + 1][0] = 2;
                            if (alea % 2 != 0 && nbChaumieres > 0) {
                                nbChaumieres = placerTuile(plateau, i, 12 * j + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                            } else if (alea % 2 == 0 && nbAutre > 0) {
                                nbAutre = placerTuile(plateau, i, 12 * j + 1, autre, 5, nbAutre);
                            } else {
                                if (nbChaumieres > 0) {
                                    nbChaumieres = placerTuile(plateau, i, 12 * j + 1, chaumiere, nbVictimesChaumieres, nbChaumieres);
                                } else if (nbAutre > 0) {
                                    nbAutre = placerTuile(plateau, i, 12 * j + 1, autre, 5, nbAutre);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Initialise et retourne une pile contenant des valeurs aléatoires tirées d'une liste créée au préalable.
     *
     * @return Une pile (ArrayList) contenant des valeurs aléatoires.
     */
    public static ArrayList<Integer> initialiserPileAleatoirement() {
        ArrayList<Integer> pile = new ArrayList<>();
        ArrayList<Integer> valeurs = Logique.creerListeNElements(20, 1);
        int nbValeurs = valeurs.size();
        int indiceAleatoire;

        for (int i = 0; i < nbValeurs; i++) {
            indiceAleatoire = (int)(Math.random() * valeurs.size());
            pile.add(valeurs.get(indiceAleatoire));
            valeurs.remove(indiceAleatoire);
        }

        return pile;
    }

    public static int placerTuile(int[][][] plateau, int ligneTuile, int colonneTuile, int numTuile, int nbVictimesTuile, int nbTuile) {
        plateau[ligneTuile][colonneTuile][1] = numTuile;
        plateau[ligneTuile][colonneTuile][2] = nbVictimesTuile;
        //nbTuile--;
        return nbTuile;
    }
}
