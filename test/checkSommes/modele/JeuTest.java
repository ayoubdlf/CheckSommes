package checkSommes.modele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JeuTest {

    @Test
    void testSwitchMode() {
        Jeu jeu = new Jeu();
        assertTrue(jeu.enModeNon());

        jeu.switchMode();

        assertTrue(jeu.enModeOui());
        assertFalse(jeu.enModeNon());
    }

    @Test
    void testEnModeOui() {
        Jeu jeu = new Jeu();
        assertFalse(jeu.enModeOui());

        jeu.switchMode();

        assertTrue(jeu.enModeOui());
    }

    @Test
    void testEnModeNon() {
        Jeu jeu = new Jeu();
        assertTrue(jeu.enModeNon());

        jeu.switchMode();

        assertFalse(jeu.enModeNon());
    }

    @Test
    void testGetNbVies() {
        Jeu jeu = new Jeu();
        assertEquals(5, jeu.getNbVies());
    }

    @Test
    void testGetValeur() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        int[][] cases = {
            { 1, 2, 1, 2, 2 },
            { 3, 3, 2, 1, 6 },
            { 2, 7, 2, 7, 2 },
            { 3, 1, 5, 1, 6 }
        };

        for (int ligne = 0; ligne < cases.length; ligne++) {
            for (int colonne = 0; colonne < cases[ligne].length; colonne++) {
                assertEquals(cases[ligne][colonne], jeu.getValeur(ligne, colonne));
            }
        }
    }

    @Test
    void testGetCouleur() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        int[][] cases = {
            { 1, 2, 1, 2, 2 },
            { 3, 3, 2, 1, 6 },
            { 2, 7, 2, 7, 2 },
            { 3, 1, 5, 1, 6 }
        };

        for (int ligne = 0; ligne < cases.length; ligne++) {
            for (int colonne = 0; colonne < cases[ligne].length; colonne++) {
                assertEquals(cases[ligne][colonne], jeu.getValeur(ligne, colonne));
            }
        }


    }

    @Test
    void testGetNbLignes() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        int[][] cases = {
            { 1, 2, 1, 2, 2 },
            { 3, 3, 2, 1, 6 },
            { 2, 7, 2, 7, 2 },
            { 3, 1, 5, 1, 6 }
        };

        for (int ligne = 0; ligne < cases.length; ligne++) {
            for (int colonne = 0; colonne < cases[ligne].length; colonne++) {
                assertEquals(cases[ligne][colonne], jeu.getValeur(ligne, colonne));
            }
        }
    }

    @Test
    void testGetNbColonnes() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        int[][] cases = {
            { 1, 2, 1, 2, 2 },
            { 3, 3, 2, 1, 6 },
            { 2, 7, 2, 7, 2 },
            { 3, 1, 5, 1, 6 }
        };

        for (int ligne = 0; ligne < cases.length; ligne++) {
            for (int colonne = 0; colonne < cases[ligne].length; colonne++) {
                assertEquals(cases[ligne][colonne], jeu.getValeur(ligne, colonne));
            }
        }
    }

    @Test
    void testSommeLigne() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        // int[][] cases = {
        //     { 1, 2, 1, 2, 2 }, // 6
        //     { 3, 3, 2, 1, 6 }, // 5
        //     { 2, 7, 2, 7, 2 }, // 9
        //     { 3, 1, 5, 1, 6 }  // 7
        // };

        assertEquals(6, jeu.sommeLigne(0));
        assertEquals(5, jeu.sommeLigne(1));
        assertEquals(9, jeu.sommeLigne(2));
        assertEquals(7, jeu.sommeLigne(3));
    }

    @Test
    void testSommeColonne() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        // int[][] cases = {
        //         { 1, 2, 1, 2, 2 },
        //         { 3, 3, 2, 1, 6 },
        //         { 2, 7, 2, 7, 2 },
        //         { 3, 1, 5, 1, 6 }
        //         //    2  6  2  9  8
        // };

        assertEquals(2, jeu.sommeColonne(0));
        assertEquals(6, jeu.sommeColonne(1));
        assertEquals(2, jeu.sommeColonne(2));
        assertEquals(9, jeu.sommeColonne(3));
        assertEquals(8, jeu.sommeColonne(4));
    }

    @Test
    void testEstSolution() {
        Jeu jeu = new Jeu(); // il aura le monde `FabriquePlateau.FabriquePlateau5x5()`

        int[][] cases = {
            { 1, 2, 1, 2, 2 },
            { 3, 3, 2, 1, 6 },
            { 2, 7, 2, 7, 2 },
            { 3, 1, 5, 1, 6 }
        };

        boolean[][] solution = {
                { false, true , false, true , true  },
                { false, true , true , false, false },
                { true , false, false, true , false },
                { false, true , false, false, true  }
        };

        for (int ligne = 0; ligne < cases.length; ligne++) {
            for (int colonne = 0; colonne < cases[ligne].length; colonne++) {
                assertEquals(solution[ligne][colonne], jeu.estSolution(ligne, colonne));
            }
        }
    }

}