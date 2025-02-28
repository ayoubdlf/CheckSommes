package checkSommes.modele;

import checkSommes.utils.Couleur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CaseTest {

    @Test
    void testGetValeur() {
        Case case1 = new Case(1);
        Case case2 = new Case(2);
        Case case3 = new Case(3);

        assertEquals(1, case1.getValeur());
        assertEquals(2, case2.getValeur());
        assertEquals(3, case3.getValeur());
    }

    @Test
    void testGetCouleur() {
        Case case1 = new Case(1);
        Case case2 = new Case(2);
        Case case3 = new Case(3);

        assertEquals(Couleur.VERT.getNumero(), case1.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case2.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case3.getCouleur());
    }

    @Test
    void testEstChoisie() {
        Case case1 = new Case(1);
        Case case2 = new Case(2);
        Case case3 = new Case(3);

        assertFalse(case1.estChoisie());
        assertFalse(case2.estChoisie());
        assertFalse(case3.estChoisie());

        assertEquals(Couleur.VERT.getNumero(), case1.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case2.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case3.getCouleur());


        case1.choisir();
        case2.choisir();
        case3.choisir();


        assertTrue(case1.estChoisie());
        assertTrue(case2.estChoisie());
        assertTrue(case3.estChoisie());
    }

    @Test
    void testSetEstSolution() {
        Case case1 = new Case(1);
        Case case2 = new Case(2);
        Case case3 = new Case(3);

        assertFalse(case1.estSolution());
        assertFalse(case2.estSolution());
        assertFalse(case3.estSolution());

        assertEquals(Couleur.VERT.getNumero(), case1.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case2.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case3.getCouleur());

        case1.setEstSolution();
        case2.setEstSolution();
        case3.setEstSolution();

        assertTrue(case1.estSolution());
        assertTrue(case2.estSolution());
        assertTrue(case3.estSolution());
    }

    @Test
    void testEstSolution() {
        Case case1 = new Case(1);
        Case case2 = new Case(2);
        Case case3 = new Case(3);

        assertFalse(case1.estSolution());
        assertFalse(case2.estSolution());
        assertFalse(case3.estSolution());

        assertEquals(Couleur.VERT.getNumero(), case1.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case2.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case3.getCouleur());

        case1.setEstSolution();
        case2.setEstSolution();
        case3.setEstSolution();

        assertTrue(case1.estSolution());
        assertTrue(case2.estSolution());
        assertTrue(case3.estSolution());
    }

    @Test
    void testChoisir() {
        Case case1 = new Case(1);
        Case case2 = new Case(2);
        Case case3 = new Case(3);

        assertFalse(case1.estChoisie());
        assertFalse(case2.estChoisie());
        assertFalse(case3.estChoisie());

        assertEquals(Couleur.VERT.getNumero(), case1.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case2.getCouleur());
        assertEquals(Couleur.VERT.getNumero(), case3.getCouleur());

        case1.choisir();
        case2.choisir();
        case3.choisir();

        assertTrue(case1.estChoisie());
        assertTrue(case2.estChoisie());
        assertTrue(case3.estChoisie());
    }
}