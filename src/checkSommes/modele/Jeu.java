package checkSommes.modele;

import checkSommes.ig.Observateur;
import java.util.ArrayList;


public class Jeu {

    private ArrayList<Observateur> observateurs; // Liste des observateurs qui seront notifiés des changements
    private boolean mode;                        // Indique le mode actuel du jeu : true = oui, false = non
    private int nbVies;                          // Indique le nombre de vies restantes


    /**
     * Constructeur de la classe Jeu.
     */
    public Jeu() {
        this.observateurs = new ArrayList<>();
        this.mode         = false;
        this.nbVies       = 5;
    }

    /**
     * Ajoute un observateur à la liste des observateurs.
     *
     * @param observateur L'observateur à ajouter. Ne doit pas être nul.
     * @throws AssertionError si l'observateur est nul.
     */
    public void ajouterObservateur(Observateur observateur) {
        assert (observateur != null) : "L'observateur ne doit pas etre nul";

        this.observateurs.add(observateur);
    }

    /**
     * Notifie tous les observateurs en appelant leur méthode 'reagir'.
     */
    public void notifierObservateurs() {
        for(Observateur observateur : this.observateurs) {
            observateur.reagir();
        }
    }

    /**
     * Change le mode du jeu (inverse le mode actuel).
     * Notifie tous les observateurs du changement de mode.
     */
    public void switchMode() {
        this.mode = !this.mode;
        this.notifierObservateurs();
    }

    /**
     * Vérifie si le mode actuel est 'oui'.
     * 
     * @return true si le mode est 'oui', false sinon.
     */
    public boolean enModeOui() {
        return this.mode;
    }

    /**
     * Vérifie si le mode actuel est 'non'.
     * 
     * @return true si le mode est 'non', false sinon.
     */
    public boolean enModeNon() {
        return !this.mode;
    }

    /**
     * Retourne le nombre de vies restantes dans le jeu.
     * 
     * @return Le nombre de vies restantes.
     */
    public int getNbVies() {
        return this.nbVies;
    }

}
