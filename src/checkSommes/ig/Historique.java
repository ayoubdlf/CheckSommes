package checkSommes.ig;

import checkSommes.modele.Coup;
import checkSommes.modele.Jeu;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Historique extends VBox implements Observateur {

    private Jeu jeu;


    public Historique(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.afficherCoups();

        VBox.setVgrow(this, Priority.ALWAYS);
        Tooltip.install(this, new Tooltip("Historique des coups"));
    }

    /**
     * Méthode appelée pour réagir aux changements dans le jeu.
     * Affiche les coups joués.
     */
    public void reagir() {
        this.afficherCoups();
    }

    /**
     * Affiche les coups joués.
     */
    private void afficherCoups() {
        this.getChildren().clear();

        this.getChildren().add(new Label("Historique (case/sommes)"));

        for(Coup coup : this.jeu) {
            Label label = new Label(coup.toString());
            if(coup.estAvecAide()) {
                label.setTextFill(Color.RED);
            }
            this.getChildren().add(label);
        }
    }

}
