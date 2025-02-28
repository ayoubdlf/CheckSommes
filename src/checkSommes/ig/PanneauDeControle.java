package checkSommes.ig;

import checkSommes.modele.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class PanneauDeControle extends HBox implements Observateur {

    private Jeu    jeu;
    private Button buttonMode;
    private Button buttonAide;

    public PanneauDeControle(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.buttonMode = new Button(this.jeu.enModeOui() ? "Oui" : "Non");
        this.buttonAide = new Button("Aide");

        this.buttonMode.setOnAction(e -> this.jeu.switchMode());
        this.buttonAide.setOnAction(e -> this.jeu.aider());

        this.getChildren().addAll(this.buttonMode, this.buttonAide);
        this.setAlignment(Pos.CENTER);
    }

    public void reagir() {
        this.buttonMode.setText(this.jeu.enModeOui() ? "Oui" : "Non");
    }

}
