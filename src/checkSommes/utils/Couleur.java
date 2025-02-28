package checkSommes.utils;


import javafx.scene.paint.Color;


/**
 * Enumération représentant les différentes couleurs disponibles pour les cases.
 */
public enum Couleur {
    VERT, GRIS, CORAIL;

    /**
     * Retourne l'identifiant de la couleur.
     * @return L'identifiant de la couleur.
     */
    public int getNumero() {
        return switch (this) {
            case VERT   -> 1;
            case GRIS   -> 2;
            case CORAIL -> 3;
        };
    }

    /**
     * Retourne la couleur correspondante.
     * @param numero Le numéro de la couleur.
     * @return La couleur correspondante.
     */
    public static Color getCouleur(int numero) {
        return switch (numero) {
            case 1  -> Color.LIGHTGREEN;
            case 2  -> Color.LIGHTGRAY;
            case 3  -> Color.LIGHTCORAL;
            default -> null;
        };
    }
}
