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

}