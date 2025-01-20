import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe `Logique` contient diverses méthodes pour gérer les opérations liées à la manipulation de
 * collections, la génération de nombres aléatoires, et la gestion de piles de cartes dans un jeu.
 * Les méthodes incluent des opérations de base comme la création de listes, la gestion de cartes (piocher, défausser),
 * et la manipulation de données simples comme des entiers et des chaînes de caractères.
 */
public class Logique {
    //public static ArrayList<Integer> pilePropagation;

    /**
     * Génère un nombre entier aléatoire compris entre 1 et la valeur maximale spécifiée.
     *
     * @param maximaleValeur La valeur maximale du nombre aléatoire généré.
     * @return Un entier aléatoire compris entre 1 et `maximaleValeur`.
     */
    /*public static int choisiNombreAleatoire(int maximaleValeur) {
        return (int) (Math.random() * maximaleValeur + 1);
    }*/

    /**
     * Crée une ArrayList contenant des entiers allant de `debut` à `n + debut - 1`.
     *
     * @param n Le nombre d'éléments à ajouter à la liste.
     * @param debut La valeur de départ à partir de laquelle commencer à remplir la liste.
     * @return Une ArrayList contenant les entiers de `debut` à `n + debut - 1`.
     */
    public static ArrayList<Integer> creerListeNElements(int n, int debut) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val = debut; val < n + debut; val++) {
            res.add(val);
        }
        return res;
    }

    /**
     * Pioche un certain nombre de cartes de la pile et les retourne dans une nouvelle ArrayList.
     * La pile est modifiée en conséquence, les cartes sont supprimées de la pile.
     *
     * @param pile La pile de cartes à piocher.
     * @param nbAPiocher Le nombre de cartes à piocher.
     * @return Une ArrayList contenant les cartes piochées.
     */
    public static ArrayList<Integer> piocherPile(ArrayList<Integer> pile, int nbAPiocher) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nbAPiocher <= pile.size() && nbAPiocher != 0) {
            for (int i =    0; i < nbAPiocher; i++) {
                res.add(pile.get(pile.size() - 1)); // Récupère la dernière carte de la pile
                pile.remove(pile.size() - 1); // Retire la dernière carte de la pile
            }
        }
        return res;
    }

    /**
     * Défausse une carte de la `file` et l'ajoute à la `pile`.
     * La carte est retirée de la `file` à l'indice spécifié.
     *
     * @param pile La pile où ajouter la carte défaussée.
     * @param file La file de cartes d'où la carte est retirée.
     * @param indiceCarte L'indice de la carte à défausser dans la `file`.
     */
    public static void defausser(ArrayList<Integer> pile, ArrayList<Integer> file, int indiceCarte) {
        pile.add(file.get(indiceCarte)); // Ajoute la carte à la pile
        file.remove(indiceCarte); // Retire la carte de la file
    }

    /**
     * Trouve l'indice d'une carte spécifique dans la `file` de cartes.
     *
     * @param file La liste des cartes dans laquelle rechercher la carte.
     * @param numeroCarte Le numéro de la carte à rechercher.
     * @return L'indice de la carte dans la `file`, ou -1 si elle n'est pas trouvée.
     */
    public static int trouverIndiceCarte(ArrayList<Integer> file, int numeroCarte) {
        for (int i = 0; i < file.size(); i++) {
            if (file.get(i) == numeroCarte) {
                return i;
            }
        }
        return -1; // Retourne -1 si la carte n'est pas trouvée
    }

    /**
     * Trouve l'indice d'une couleur dans un tableau de couleurs.
     * Le tableau contient les couleurs en toute lettre, et cette méthode retourne l'indice de la couleur spécifiée.
     *
     * @param tableauCouleurs Le tableau de couleurs sous forme de chaînes.
     * @param couleur La couleur dont l'indice doit être trouvé.
     * @return L'indice de la couleur dans le tableau, ou -1 si la couleur n'est pas trouvée.
     */
    public static int trouverIndiceCouleur(String[] tableauCouleurs, String couleur) {
        for (int i = 0; i < tableauCouleurs.length; i++) {
            if (tableauCouleurs[i].equals(couleur)) {
                return i;
            }
        }
        return -1; // Retourne -1 si la couleur n'est pas trouvée
    }

    /**
     * Vérifie si une valeur existe dans un tableau de chaînes, en ignorant un indice spécifique.
     *
     * @param tableau Le tableau de chaînes à parcourir.
     * @param valeur La valeur à rechercher dans le tableau.
     * @param indiceAIgnorer L'indice à ignorer lors de la recherche.
     * @return True si la valeur existe dans le tableau (en dehors de l'indice à ignorer), sinon false.
     */
    public static boolean elementExisteDansTableauString(String[] tableau, String valeur, int indiceAIgnorer) {
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] != null && tableau[i].equalsIgnoreCase(valeur) && i != indiceAIgnorer) {
                return true; // La valeur existe dans le tableau en dehors de l'indice à ignorer
            }
        }
        return false; // La valeur n'existe pas dans le tableau
    }
    public static boolean elementExisteDansTableauString(String[] tableau, String valeur) {
        return elementExisteDansTableauString(tableau, valeur, -1);
    }

    /**
     * Vérifie si un objectif a été atteint par l'un des joueurs ou des équipes.
     * Cette fonction compare les scores des joueurs ou des équipes aux objectifs en fonction du mode de jeu.
     *
     * @param nbJoueurs      Le nombre total de joueurs dans la partie.
     * @param victimesJoueurs Un tableau contenant les scores des joueurs (nombre de victimes).
     * @param deuxContreDeux Une valeur booléenne indiquant si le jeu est en mode 2 contre 2 :
     *                       - `true` : les scores des paires d'équipes sont additionnés pour vérifier l'objectif.
     *                       - `false` : le score individuel de chaque joueur est vérifié.
     * @return               `true` si un joueur ou une équipe a atteint l'objectif, sinon `false`.
     */
    public static boolean objectifAtteintJoueurs(int nbJoueurs, int[] victimesJoueurs, boolean deuxContreDeux) {
        int objectif = 0;

        if (nbJoueurs == 3) {
            objectif = 60;
        } else if (nbJoueurs == 4) {
            objectif = 50;
        } else { // Si il y a 5 joueurs
            objectif = 45;
        }

        if (deuxContreDeux) {
            if (victimesJoueurs[0] + victimesJoueurs[1] == objectif || victimesJoueurs[2] + victimesJoueurs[3] == objectif) {
                return true;
            }
        } else {
            for (int i = 0; i < victimesJoueurs.length; i++) {
                if (victimesJoueurs[i] >= objectif) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Vérifie si toutes les files de jeu sont vides.
     *
     * @param files      Un tableau d'ArrayList représentant les files (ou piles) des joueurs.
     * @param nbJoueurs  Le nombre de joueurs dans la partie.
     * @return           `true` si toutes les files sont vides, sinon `false`.
     */
    public static boolean filesVides(ArrayList<Integer>[] files, int nbJoueurs) {
        int cpt = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].size() == 0) {
                cpt++;
            }
        }
        return cpt == nbJoueurs;
    }

    /**
     * Trie les indices des valeurs de la liste dans l'ordre croissant en utilisant un tri par sélection.
     *
     * @param liste  Une liste d'entiers à trier.
     * @return       Un tableau d'entiers représentant les indices triés de la liste.
     */
    public static int[] triABulles(ArrayList<Integer> liste) {
        int n = liste.size();
        int[] indices = new int[n];

        // Initialiser les indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        for (int i = 0; i < n - 1; i++) {
            // Trouver l'indice du plus petit élément dans la partie non triée de la liste
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // Comparer les éléments de la liste en utilisant les indices
                if (liste.get(indices[j]) < liste.get(indices[minIndex])) {
                    minIndex = j;
                }
            }

            // Échanger les indices
            int temp = indices[i];
            indices[i] = indices[minIndex];
            indices[minIndex] = temp;
        }

        return indices;
    }

    /**
     * Suspend l'exécution du programme pendant un certain temps.
     *
     * @param delaiMs  Le délai d'attente en millisecondes.
     */
    public static void attendre(int delaiMs) {
        try {
            Thread.sleep(delaiMs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viderBuffer() {
        while (true) {
            try {
                if (!(System.in.available() > 0)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }





    // Changement laissé de côté pour le moment, mais c'est une bonne idée à garder, mais a mieux programmer aussi mdr
    /*public static void executerCommande(String commande) {
        String[] listeCommandes = copierTableauString(Affichage.listeCommandes);
        if (commande.equals(listeCommandes[0])) { // "q"
            // Pour que ca fonctionne il faut avoir le nombre de joueur donc deja etre dans une partie
            // Pour le moment on assume que cette commande est lancé forcément quand on est en partie
            initierVotePourQuitterLaPartie(Jeu.nbJoueurs);
        }
    }

    public static void initierVotePourQuitterLaPartie(int nbJoueurs) {

    }

    public static String[] copierTableauString(String[] tableauACopier) {
        String[] copieTableau = new String[tableauACopier.length];
        for (int i = 0; i < tableauACopier.length; i++) {
            copieTableau[i] = tableauACopier[i];
        }
    }*/
}
