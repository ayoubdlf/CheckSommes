package checkSommes.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoupTest {

    @Test
    void testGetLigne() {
        Coup coup1 = new Coup(1, 1, 1, 1);
        Coup coup2 = new Coup(2, 1, 1, 1);
        Coup coup3 = new Coup(3, 1, 1, 1);

        assertEquals(1, coup1.getLigne());
        assertEquals(2, coup2.getLigne());
        assertEquals(3, coup3.getLigne());
    }

    @Test
    void testGetColonne() {
        Coup coup1 = new Coup(1, 1, 1, 1);
        Coup coup2 = new Coup(1, 2, 1, 1);
        Coup coup3 = new Coup(1, 3, 1, 1);

        assertEquals(1, coup1.getColonne());
        assertEquals(2, coup2.getColonne());
        assertEquals(3, coup3.getColonne());
    }

    @Test
    void testGetSommeLigne() {
        Coup coup1 = new Coup(1, 1, 1, 1);
        Coup coup2 = new Coup(1, 1, 2, 1);
        Coup coup3 = new Coup(1, 1, 3, 1);

        assertEquals(1, coup1.getSommeLigne());
        assertEquals(2, coup2.getSommeLigne());
        assertEquals(3, coup3.getSommeLigne());
    }

    @Test
    void testGetSommeColonne() {
        Coup coup1 = new Coup(1, 1, 1, 1);
        Coup coup2 = new Coup(1, 1, 1, 2);
        Coup coup3 = new Coup(1, 1, 1, 3);

        assertEquals(1, coup1.getSommeColonne());
        assertEquals(2, coup2.getSommeColonne());
        assertEquals(3, coup3.getSommeColonne());
    }

    @Test
    void testGetAide() {
        Coup coup1 = new Coup(1, 1, 1, 1);
        Coup coup2 = new Coup(1, 1, 1, 1);
        Coup coup3 = new Coup(1, 1, 1, 1);

        coup2.setEstAvecAide(true);
        assertFalse(coup1.estAvecAide());
        assertTrue(coup2.estAvecAide());
        assertFalse(coup3.estAvecAide());
    }

    @Test
    void testEstSolution() {
        Coup coup1 = new Coup(1, 1, 1, 1);
        Coup coup2 = new Coup(1, 1, 1, 1);
        Coup coup3 = new Coup(1, 1, 1, 1);

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