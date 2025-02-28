package checkSommes.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoupTest {

    @Test
    void testGetLigne() {
        Coup coup1 = new Coup(1, 1, 1, 1, false);
        Coup coup2 = new Coup(2, 1, 1, 1, false);
        Coup coup3 = new Coup(3, 1, 1, 1, false);

        assertEquals(1, coup1.getLigne());
        assertEquals(2, coup2.getLigne());
        assertEquals(3, coup3.getLigne());
    }

    @Test
    void testGetColonne() {
        Coup coup1 = new Coup(1, 1, 1, 1, false);
        Coup coup2 = new Coup(1, 2, 1, 1, false);
        Coup coup3 = new Coup(1, 3, 1, 1, false);

        assertEquals(1, coup1.getColonne());
        assertEquals(2, coup2.getColonne());
        assertEquals(3, coup3.getColonne());
    }

    @Test
    void testGetSommeLigne() {
        Coup coup1 = new Coup(1, 1, 1, 1, false);
        Coup coup2 = new Coup(1, 1, 2, 1, false);
        Coup coup3 = new Coup(1, 1, 3, 1, false);

        assertEquals(1, coup1.getSommeLigne());
        assertEquals(2, coup2.getSommeLigne());
        assertEquals(3, coup3.getSommeLigne());
    }

    @Test
    void testGetSommeColonne() {
        Coup coup1 = new Coup(1, 1, 1, 1, false);
        Coup coup2 = new Coup(1, 1, 1, 2, false);
        Coup coup3 = new Coup(1, 1, 1, 3, false);

        assertEquals(1, coup1.getSommeColonne());
        assertEquals(2, coup2.getSommeColonne());
        assertEquals(3, coup3.getSommeColonne());
    }

    @Test
    void testGetAide() {
        Coup coup1 = new Coup(1, 1, 1, 1, false);
        Coup coup2 = new Coup(1, 1, 1, 1, true);
        Coup coup3 = new Coup(1, 1, 1, 1, false);

        assertFalse(coup1.getAide());
        assertTrue(coup2.getAide());
        assertFalse(coup3.getAide());
    }

    @Test
    void testEstSolution() {
        Coup coup1 = new Coup(1, 1, 1, 1, false);
        Coup coup2 = new Coup(1, 1, 1, 1, false);
        Coup coup3 = new Coup(1, 1, 1, 1, false);

        assertFalse(coup1.estSolution());
        assertFalse(coup2.estSolution());
        assertFalse(coup3.estSolution());

        coup1.setEstSolution(true);
        coup2.setEstSolution(true);
        coup3.setEstSolution(true);

        assertTrue(coup1.estSolution());
        assertTrue(coup2.estSolution());
        assertTrue(coup3.estSolution());
    }
}