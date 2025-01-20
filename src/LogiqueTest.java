import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class LogiqueTest {

    /**
     * Test avec une pile classique et un nombre standard de cartes à piocher
     */
    @Test
    void testPiocherPileCasClassique() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        int nbAPiocher = 4;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertEquals(Arrays.asList(60, 50, 40, 30), cartesPiochées, "Les cartes piochées ne correspondent pas.");
        assertEquals(Arrays.asList(10, 20), pile, "La pile restante ne correspond pas.");
    }

    /**
     * Test avec une pile vide
     */
    @Test
    void testPiocherPileVide() {
        ArrayList<Integer> pile = new ArrayList<>();
        int nbAPiocher = 3;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertTrue(cartesPiochées.isEmpty(), "Aucune carte ne devrait être piochée car la pile est vide.");
        assertTrue(pile.isEmpty(), "La pile devrait toujours être vide.");
    }

    /**
     * Test avec une pile ne contenant qu’un seul élément
     */
    @Test
    void testPiocherPileUnSeulElement() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(99));
        int nbAPiocher = 1;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertEquals(Arrays.asList(99), cartesPiochées, "La seule carte doit être piochée.");
        assertTrue(pile.isEmpty(), "La pile doit être vide après avoir pioché la seule carte.");
    }

    /**
     * Test où le nombre de cartes à piocher dépasse la taille de la pile
     */
    @Test
    void testPiocherPileDemandeExcessive() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(1, 2, 3));
        int nbAPiocher = 5;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertTrue(cartesPiochées.isEmpty(), "Aucune carte ne doit être piochée si le nombre demandé est excessif.");
        assertEquals(Arrays.asList(1, 2, 3), pile, "La pile devrait rester intacte.");
    }

    /**
     * Test où le nombre de cartes demandé est zéro
     */
    @Test
    void testPiocherPileAvecZero() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(10, 20, 30));
        int nbAPiocher = 0;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertTrue(cartesPiochées.isEmpty(), "Aucune carte ne doit être piochée si 0 est demandé.");
        assertEquals(Arrays.asList(10, 20, 30), pile, "La pile ne doit pas être modifiée.");
    }

    /**
     * Test avec une pile et des doublons
     */
    @Test
    void testPiocherPileAvecDoublons() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
        int nbAPiocher = 3;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertEquals(Arrays.asList(5, 5, 5), cartesPiochées, "Les cartes piochées doivent contenir trois éléments identiques.");
        assertEquals(Arrays.asList(5, 5), pile, "Les deux éléments restants doivent être identiques.");
    }

    /**
     * Test sur une pile avec un grand nombre d'éléments
     */
    @Test
    void testPiocherPileAvecGrandNombre() {
        ArrayList<Integer> pile = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            pile.add(i);
        }
        int nbAPiocher = 500;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertEquals(500, cartesPiochées.size(), "Il devrait y avoir exactement 500 cartes piochées.");
        assertEquals(500, pile.size(), "Il devrait rester exactement 500 cartes dans la pile initiale.");
        for (int i = 0; i < 500; i++) {
            assertEquals(1000 - i, cartesPiochées.get(i), "Les cartes doivent être prélevées depuis le haut de la pile.");
        }
    }

    /**
     * Test où le nombre à piocher est exactement égal à la taille de la pile
     */
    @Test
    void testPiocherPileExactementEgale() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int nbAPiocher = 5;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertEquals(Arrays.asList(50, 40, 30, 20, 10), cartesPiochées, "Toutes les cartes doivent être piochées dans l'ordre inverse.");
        assertTrue(pile.isEmpty(), "La pile devrait être vide après avoir tout pioché.");
    }

    /**
     * Test mixte sur une pile ayant des nombres aléatoires
     */
    @Test
    void testPiocherPileValeursAleatoires() {
        ArrayList<Integer> pile = new ArrayList<>(Arrays.asList(21, 5, 18, 3, 99, 77, 32));
        int nbAPiocher = 4;

        ArrayList<Integer> cartesPiochées = piocherPile(pile, nbAPiocher);

        // Validation des résultats
        assertEquals(Arrays.asList(32, 77, 99, 3), cartesPiochées, "Les quatre dernières cartes doivent être correctement piochées.");
        assertEquals(Arrays.asList(21, 5, 18), pile, "Le reste de la pile doit contenir les cartes non piochées.");
    }

    /**
     * Implémentation de la méthode à tester (utile pour exécuter les tests directement ici)
     */
    private static ArrayList<Integer> piocherPile(ArrayList<Integer> pile, int nbAPiocher) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nbAPiocher <= pile.size() && nbAPiocher != 0) {
            for (int i = 0; i < nbAPiocher; i++) {
                res.add(pile.remove(pile.size() - 1)); // Retire et ajoute la dernière carte
            }
        }
        return res;
    }
}