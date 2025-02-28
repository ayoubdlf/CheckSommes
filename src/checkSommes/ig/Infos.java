package checkSommes.ig;

import checkSommes.modele.Jeu;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;


public class Infos extends HBox implements Observateur {

    private Jeu         jeu;
    private ImageView[] coeurs;


    /**
     * Constructeur de la classe Infos.
     *
     * @param jeu Le jeu pour lequel cette instance d'Infos agit comme observateur.
     */
    public Infos(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.initCoeurs();

        // this.setAlignment(Pos.CENTER);
    }

    /**
     * Méthode appelée pour réagir aux changements dans le jeu.
     * Réinitialise les coeurs affichés.
     */
    public void reagir() {
        this.initCoeurs();
    }

    /**
     * Initialise les coeurs en fonction du nombre de vies restantes dans le jeu.
     * Efface les coeurs existants et ajoute de nouveaux coeurs si le nombre de vies est supérieur à zéro.
     */
    private void initCoeurs() {
        this.getChildren().clear();

        if(this.jeu.getNbVies() <= 0) { return; }

        this.coeurs = new ImageView[this.jeu.getNbVies()];

        for (int i = 0; i < this.coeurs.length; i++) {
            this.coeurs[i] = new ImageView();
            this.coeurs[i].setImage(new Image(getClass().getResource("/coeur.png").toExternalForm()));
            this.coeurs[i].setFitWidth(30);
            this.coeurs[i].setPreserveRatio(true);
        }

        for(ImageView coeur : this.coeurs) {
            this.getChildren().add(coeur);
        }
    }

}
