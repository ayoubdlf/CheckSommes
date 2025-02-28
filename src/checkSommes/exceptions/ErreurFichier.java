package checkSommes.exceptions;

/**
 * Exception personnalisée pour gérer les erreurs liées aux fichiers.
 * Cette classe étend la classe Exception standard de Java.
 */
public class ErreurFichier extends Exception {

    /**
     * Constructeur de l'exception ErreurFichier.
     *
     * @param message Le message d'erreur à associer à l'exception
     */
    public ErreurFichier(String message) {
        super(message);
    }

}