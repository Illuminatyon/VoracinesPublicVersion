import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhasePlanificationTest {

    /*@Test
    void testChoisiNombrePourTableauModificationDesPositions() {
        // Préparer un tableau avec des positions non nulles
        int[][][] tableau = new int[5][5][3];
        tableau[0][0] = new int[]{1, 0, 0}; // Position non nulle
        tableau[1][2] = new int[]{0, 1, 0}; // Position non nulle
        tableau[3][4] = new int[]{0, 0, 1}; // Position non nulle

        // Appeler la méthode
        ArrayList<int[]> positionsModifiees = PhasePlanification.choisiNombrePourTableau(tableau);

        // Vérifier que 3 positions ont été modifiées
        assertEquals(3, positionsModifiees.size(), "Toutes les positions non nulles devraient être modifiées.");

        // Vérifier les valeurs du tableau
        for (int[] position : positionsModifiees) {
            int[] valeur = tableau[position[0]][position[1]];
            assertTrue((valeur[0] == 2 && valeur[1] == 2 && valeur[2] == 10) ||
                            (valeur[0] == 2 && valeur[1] == 5 && valeur[2] == 5),
                    "Les cellules modifiées doivent contenir soit {2, 2, 10}, soit {2, 5, 5}.");
        }
    }

    @Test
    void testChoisiNombrePourTableauLimiteNombreDeTransmutation() {
        // Préparer un tableau avec plusieurs positions non nulles
        int[][][] tableau = new int[6][6][3];
        tableau[0][0] = new int[]{1, 1, 1};
        tableau[0][1] = new int[]{1, 1, 1};
        tableau[0][2] = new int[]{1, 1, 1};
        tableau[0][3] = new int[]{1, 1, 1};
        tableau[0][4] = new int[]{1, 1, 1};
        tableau[0][5] = new int[]{1, 1, 1};

        // Appeler la méthode
        ArrayList<int[]> positionsModifiees = PhasePlanification.choisiNombrePourTableau(tableau);

        // Vérifier que les 6 premières positions contiennent {2, 2, 10}
        for (int i = 0; i < 6; i++) {
            int[] pos = positionsModifiees.get(i);
            assertArrayEquals(new int[]{2, 2, 10}, tableau[pos[0]][pos[1]]);
        }

        // Aucune valeur restante ne doit contenir d'autres valeurs après les 6 premières
        if (positionsModifiees.size() > 6) {
            for (int i = 6; i < positionsModifiees.size(); i++) {
                int[] pos = positionsModifiees.get(i);
                assertArrayEquals(new int[]{2, 5, 5}, tableau[pos[0]][pos[1]]);
            }
        }
    }

    @Test
    void testChoisiNombrePourTableauAucunePositionNonNulle() {
        // Préparer un tableau où toutes les positions sont nulles
        int[][][] tableau = new int[3][3][3]; // Toutes les cellules contiennent {0, 0, 0}

        // Appeler la méthode
        ArrayList<int[]> positionsModifiees = PhasePlanification.choisiNombrePourTableau(tableau);

        // Vérifier que la liste des positions modifiées est vide
        assertTrue(positionsModifiees.isEmpty(), "Aucune position ne devrait être modifiée si toutes les cellules sont vides.");
    }

    @Test
    void testChoisiNombrePourTableauTableauVide() {
        // Préparer un tableau vide
        int[][][] tableau = new int[0][0][0]; // Aucun élément

        // Appeler la méthode
        ArrayList<int[]> positionsModifiees = PhasePlanification.choisiNombrePourTableau(tableau);

        // Vérifier que la liste des positions modifiées est vide
        assertTrue(positionsModifiees.isEmpty(), "Aucune position ne devrait être modifiée si le tableau est vide.");
    }

    @Test
    void testChoisiNombrePourTableauMélangeAléatoire() {
        // Préparer un tableau avec plusieurs positions non nulles
        int[][][] tableau = new int[5][5][3];
        tableau[0][0] = new int[]{1, 0, 0}; // Position non nulle
        tableau[1][1] = new int[]{0, 1, 0}; // Position non nulle
        tableau[2][2] = new int[]{0, 0, 1}; // Position non nulle
        tableau[3][3] = new int[]{1, 1, 1}; // Position non nulle
        tableau[4][4] = new int[]{1, 1, 1}; // Position non nulle

        // Faire plusieurs appels pour vérifier que le mélange est aléatoire
        ArrayList<int[]> positionsModifiees1 = PhasePlanification.choisiNombrePourTableau(tableau);
        ArrayList<int[]> positionsModifiees2 = PhasePlanification.choisiNombrePourTableau(tableau);

        // Les deux listes de positions ne doivent pas être identiques dans la majorité des appels
        assertNotEquals(positionsModifiees1, positionsModifiees2, "Les positions modifiées doivent être mélangées aléatoirement.");
    }*/
}