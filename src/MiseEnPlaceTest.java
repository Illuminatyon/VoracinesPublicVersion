import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MiseEnPlaceTest {

    @Test
    void testInitialiserPileAleatoirementNombreElements() {
        // Exécuter la méthode
        ArrayList<Integer> pile = MiseEnPlace.initialiserPileAleatoirement();

        // Vérifier que la pile contient exactement 20 éléments
        assertEquals(20, pile.size(), "La pile devrait contenir exactement 20 éléments !");
    }

    @Test
    void testInitialiserPileAleatoirementValeursDansPlage() {
        // Exécuter la méthode
        ArrayList<Integer> pile = MiseEnPlace.initialiserPileAleatoirement();

        // Vérifier que toutes les valeurs de la pile sont dans la plage [1, 20]
        for (int valeur : pile) {
            assertTrue(valeur >= 1 && valeur <= 20, "Toutes les valeurs de la pile doivent être dans la plage [1, 20] !");
        }
    }

    @Test
    void testInitialiserPileAleatoirementValeursUniques() {
        // Exécuter la méthode
        ArrayList<Integer> pile = MiseEnPlace.initialiserPileAleatoirement();

        // Vérifier que toutes les valeurs sont uniques
        HashSet<Integer> valeursUniques = new HashSet<>(pile);
        assertEquals(pile.size(), valeursUniques.size(), "Les valeurs dans la pile devraient être toutes uniques !");
    }

    @Test
    void testInitialiserPileAleatoirementContientToutesValeursExpected() {
        // Exécuter la méthode
        ArrayList<Integer> pile = MiseEnPlace.initialiserPileAleatoirement();

        // Vérifier que la pile contient exactement les valeurs 1 à 20, même si elles sont mélangées
        ArrayList<Integer> valeursAttendues = Logique.creerListeNElements(20, 1);
        assertTrue(pile.containsAll(valeursAttendues), "La pile doit contenir exactement les valeurs de 1 à 20, même si elles sont dans un ordre aléatoire !");
    }

    @Test
    void testInitialiserPileAleatoirementRandomisation() {
        // Exécuter la méthode plusieurs fois pour vérifier que les résultats sont différents
        ArrayList<Integer> pile1 = MiseEnPlace.initialiserPileAleatoirement();
        ArrayList<Integer> pile2 = MiseEnPlace.initialiserPileAleatoirement();

        // Vérifier que les deux piles ne sont pas identiques (dans une large majorité des essais)
        assertNotEquals(pile1, pile2, "Deux exécutions de la méthode devraient produire des piles différentes dans la grande majorité des cas !");
    }
}