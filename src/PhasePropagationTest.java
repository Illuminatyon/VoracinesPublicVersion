import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhasePropagationTest {

    @Test
    void testTransformerCaseEnTableauColonne1() {
        // Préparer un plateau tridimensionnel
        int[][][] plateau = new int[15][15][3];

        // Initialiser le tableau avec des valeurs spécifiques
        plateau[0][0] = new int[]{1, 2, 3}; // Cette cellule sera utilisée pour calculer res
        plateau[0][1] = new int[]{1, 4, 5};
        plateau[0][2] = new int[]{0, 8, 7}; // Ignorée car le premier élément (x) est 0
        plateau[1][2] = new int[]{1, 6, 7}; // Utilisée pour calculer res

        // Appeler la méthode
        int ligne = 0;
        int colonne = 1; // Condition spécifique pour la colonne 1
        int[][] res = PhasePropagation.transformerCaseEnTableau(plateau, ligne, colonne);

        // Vérifier les dimensions du tableau résultant (4x5)
        assertEquals(4, res.length, "Le tableau résultant doit avoir 4 lignes.");
        assertEquals(5, res[0].length, "Chaque ligne du tableau résultant doit avoir 5 colonnes.");

        // Vérifier que les valeurs sont correctement transformées à partir des éléments conformes dans le plateau
        assertEquals(3, res[0][1], "La cellule de résultat [0][1] devrait avoir la valeur 2+1.");
        assertEquals(5, res[0][2], "La cellule de résultat [0][2] devrait avoir la valeur 4+1.");
        assertEquals(7, res[1][2], "La cellule de résultat [1][2] devrait avoir la valeur 6+1.");
        assertEquals(0, res[0][0], "Les cellules ignorées doivent rester initialisées à 0.");
    }

    @Test
    void testTransformerCaseEnTableauColonne13() {
        // Préparer un plateau fictif
        int[][][] plateau = new int[15][15][3];

        // Insérer des valeurs au bon endroit
        plateau[5][12] = new int[]{1, 3, 0};
        plateau[5][13] = new int[]{1, 5, 0};
        plateau[5][14] = new int[]{0, 7, 0}; // Ignorée car x est 0

        // Appeler la méthode pour la colonne spécifique
        int[][] res = PhasePropagation.transformerCaseEnTableau(plateau, 5, 13);

        // Tester les dimensions
        assertEquals(4, res.length, "Le tableau résultant doit avoir 4 lignes.");
        assertEquals(5, res[0].length, "Chaque ligne du tableau résultant doit avoir 5 colonnes.");

        // Tester les valeurs
        assertEquals(4, res[0][1], "La cellule [0][1] devrait contenir 3+1.");
        assertEquals(6, res[0][2], "La cellule [0][2] devrait contenir 5+1.");
        assertEquals(0, res[0][3], "La cellule ignorée (x = 0) doit rester à 0.");
    }

    @Test
    void testTransformerCaseEnTableauLigne10() {
        // Préparer un plateau fictif
        int[][][] plateau = new int[15][15][3];

        // Ajouter des valeurs aux bonnes positions
        plateau[10][2] = new int[]{1, 0, 0}; // Sera converti en 1
        plateau[10][3] = new int[]{1, 4, 0}; // Sera converti en 5
        plateau[11][4] = new int[]{1, 3, 0}; // Sera converti en 4

        // Appeler la méthode
        int[][] res = PhasePropagation.transformerCaseEnTableau(plateau, 10, 3);

        // Tester les dimensions
        assertEquals(4, res.length, "Le tableau résultant doit avoir 4 lignes.");
        assertEquals(5, res[0].length, "Chaque ligne du tableau résultant doit avoir 5 colonnes.");

        // Tester les valeurs
        assertEquals(1, res[0][0], "La cellule [0][0] devrait contenir 0+1.");
        assertEquals(5, res[0][2], "La cellule [0][2] devrait contenir 4+1.");
        assertEquals(4, res[1][3], "La cellule [1][3] devrait contenir 3+1.");
    }

    @Test
    void testTransformerCaseEnTableauCasGénéral() {
        // Préparer un plateau fictif
        int[][][] plateau = new int[15][15][3];

        // Ajouter des valeurs dans un cas général
        plateau[2][3] = new int[]{1, 3, 4}; // Sera converti en 4
        plateau[3][4] = new int[]{1, 5, 6}; // Sera converti en 6
        plateau[4][5] = new int[]{0, 4, 6}; // Ignorée car x = 0

        // Appeler la méthode
        int[][] res = PhasePropagation.transformerCaseEnTableau(plateau, 2, 3);

        // Tester les dimensions
        assertEquals(4, res.length, "Le tableau résultant doit avoir 4 lignes.");
        assertEquals(5, res[0].length, "Chaque ligne du tableau résultant doit avoir 5 colonnes.");

        // Tester les valeurs
        assertEquals(4, res[0][0], "La cellule [0][0] devrait contenir 3+1.");
        assertEquals(6, res[1][1], "La cellule [1][1] devrait contenir 5+1.");
        assertEquals(0, res[2][2], "La cellule ignorée doit rester à 0.");
    }

    @Test
    void testTransformerCaseEnTableauTableauVide() {
        // Préparer un plateau vide
        int[][][] plateau = new int[0][0][0];

        // Tester un appel avec une ligne et une colonne quelconque
        int[][] res = PhasePropagation.transformerCaseEnTableau(plateau, 0, 0);

        // Vérifier que le tableau est vide mais les dimensions restent conformes
        assertEquals(4, res.length, "Le tableau résultant doit avoir 4 lignes même si l'entrée est vide.");
        assertEquals(5, res[0].length, "Chaque ligne du tableau résultant doit avoir 5 colonnes même si l'entrée est vide.");
    }

    @Test
    void testExtraireSousTableauCoinHautGauche() {
        // Préparer un plateau tridimensionnel
        int[][][] plateau = new int[4][4][2];

        // Initialiser avec des valeurs distinctes permettant de vérifier l'extraction
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                plateau[y][x] = new int[]{y, x};
            }
        }

        // Appeler la méthode pour la partie "haut gauche"
        String choix = "haut gauche";
        int[][][] sousTableau = PhasePropagation.extraireSousTableau(plateau, choix, 2, 2);

        // Vérifier les dimensions du sous-tableau
        assertEquals(2, sousTableau.length, "La hauteur du sous-tableau devrait être correcte.");
        assertEquals(2, sousTableau[0].length, "La largeur du sous-tableau devrait être correcte.");
        assertEquals(2, sousTableau[0][0].length, "La profondeur du sous-tableau devrait être correcte.");

        // Vérifier les valeurs extraites
        assertArrayEquals(new int[]{0, 0}, sousTableau[0][0], "Valeur incorrecte dans le coin haut gauche.");
        assertArrayEquals(new int[]{1, 1}, sousTableau[1][1], "Valeur incorrecte au centre du sous-tableau.");
    }

    @Test
    void testExtraireSousTableauCoinBasDroite() {
        // Préparer un plateau tridimensionnel
        int[][][] plateau = new int[6][6][2];

        // Initialiser avec des valeurs spécifiques
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                plateau[y][x] = new int[]{y, x};
            }
        }

        // Appeler la méthode pour la partie "bas droite"
        String choix = "bas droite";
        int[][][] sousTableau = PhasePropagation.extraireSousTableau(plateau, choix, 3, 3);

        // Vérifier les dimensions du sous-tableau
        assertEquals(3, sousTableau.length, "La hauteur du sous-tableau devrait être correcte.");
        assertEquals(3, sousTableau[0].length, "La largeur du sous-tableau devrait être correcte.");
        assertEquals(2, sousTableau[0][0].length, "La profondeur du sous-tableau devrait être correcte.");

        // Vérifier les valeurs extraites dans la partie correspondante
        assertArrayEquals(new int[]{3, 3}, sousTableau[0][0], "Valeur incorrecte au coin haut gauche du sous-tableau.");
        assertArrayEquals(new int[]{5, 5}, sousTableau[2][2], "Valeur incorrecte au coin bas droit du sous-tableau.");
    }

    @Test
    void testExtraireSousTableauPartieHautDroite() {
        // Préparer un plateau tridimensionnel
        int[][][] plateau = new int[5][5][2];

        // Initialiser avec des valeurs simples
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                plateau[y][x] = new int[]{y, x};
            }
        }

        // Appeler pour la partie "haut droite"
        String choix = "haut droite";
        int[][][] sousTableau = PhasePropagation.extraireSousTableau(plateau, choix, 3, 3);

        // Vérifier les dimensions
        assertEquals(3, sousTableau.length, "La hauteur devrait être correcte.");
        assertEquals(2, sousTableau[0].length, "La largeur devrait être correcte.");
        assertEquals(2, sousTableau[0][0].length, "La profondeur devrait être correcte.");

        // Vérifier les valeurs extraites
        assertArrayEquals(new int[]{0, 3}, sousTableau[0][0], "Valeur au coin haut gauche incorrecte.");
        assertArrayEquals(new int[]{2, 4}, sousTableau[2][1], "Valeur au coin bas droite incorrecte.");
    }

    @Test
    void testExtraireSousTableauPartieBasGauche() {
        // Préparer un plateau tridimensionnel
        int[][][] plateau = new int[5][5][2];

        // Initialiser avec des valeurs simples
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                plateau[y][x] = new int[]{y, x};
            }
        }

        // Appeler pour la partie "bas gauche"
        String choix = "bas gauche";
        int[][][] sousTableau = PhasePropagation.extraireSousTableau(plateau, choix, 3, 3);

        // Vérifier les dimensions
        assertEquals(2, sousTableau.length, "La hauteur devrait être correcte.");
        assertEquals(3, sousTableau[0].length, "La largeur devrait être correcte.");
        assertEquals(2, sousTableau[0][0].length, "La profondeur devrait être correcte.");

        // Vérifier les valeurs extraites
        assertArrayEquals(new int[]{3, 0}, sousTableau[0][0], "Valeur au coin haut gauche incorrecte.");
        assertArrayEquals(new int[]{4, 2}, sousTableau[1][2], "Valeur au coin bas droite incorrecte.");
    }

    @Test
    void testExtraireSousTableauPlateauVide() {
        // Plateau vide
        int[][][] plateau = new int[0][0][0];

        // Appeler la méthode
        String choix = "haut gauche";
        int[][][] sousTableau = PhasePropagation.extraireSousTableau(plateau, choix, 0, 0);

        // Vérifier que le sous-tableau est également vide
        assertEquals(0, sousTableau.length, "Le sous-tableau devrait être vide pour un plateau vide.");
    }
}