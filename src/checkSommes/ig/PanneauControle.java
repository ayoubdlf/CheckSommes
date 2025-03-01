package checkSommes.ig;

import checkSommes.modele.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;


public class PanneauControle extends HBox implements Observateur {

    private Jeu    jeu;
    private Button buttonMode;

    /**
     * Constructeur de PanneauDeControle.
     * Initialise les boutons et les actions associées.
     *
     * @param jeu L'instance du jeu à laquelle ce panneau est associé.
     */
    public PanneauControle(Jeu jeu) {
        assert(jeu != null) : "Le jeu ne doit pas etre nul";

        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.buttonMode = new Button(this.jeu.enModeOui() ? "Oui" : "Non");
        this.buttonMode.setOnAction(e -> this.jeu.switchMode());

        Button buttonAide = new Button("Aide");
        buttonAide.setOnAction(e -> {
            if(!this.jeu.jeuTermine()) {
                this.jeu.aider();
            }
        });

        this.getChildren().addAll(this.buttonMode, buttonAide);
        this.setAlignment(Pos.CENTER);

        Tooltip.install(this, new Tooltip("Panneau de contrôle"));
        Tooltip.install(buttonAide, new Tooltip("Reveler une case"));
        Tooltip.install(this.buttonMode, new Tooltip("Mode de jeu"));
    }

    /**
     * Méthode reagir qui met à jour le texte du bouton mode.
     * Appelée lorsque l'état du jeu change.
     */
    public void reagir() {
        this.buttonMode.setText(this.jeu.enModeOui() ? "Oui" : "Non");
    }

}
