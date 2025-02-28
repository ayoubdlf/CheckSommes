package checkSommes.ig;

import checkSommes.modele.Jeu;
import javafx.geometry.Pos;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;


public class Infos extends HBox implements Observateur {

    private Jeu         jeu;
    private ImageView[] coeurs;

    public Infos(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.initCoeurs();

        for(ImageView coeur : this.coeurs) {
            this.getChildren().add(coeur);
        }

        this.setAlignment(Pos.CENTER);
    }

    public void reagir() {
        this.initCoeurs();
    }

    private void initCoeurs() {
        this.coeurs = new ImageView[this.jeu.getNbVies()];
        for (int i = 0; i < this.coeurs.length; i++) {
            this.coeurs[i] = new ImageView();
            this.coeurs[i].setImage(new Image(getClass().getResource("/coeur.png").toExternalForm()));
            this.coeurs[i].setFitWidth(30);
            this.coeurs[i].setPreserveRatio(true);
        }
    }

}
