package checkSommes.ig;

import checkSommes.modele.Jeu;
import javafx.scene.control.Tooltip;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import java.util.Objects;


public class Infos extends HBox implements Observateur {

    private Jeu jeu;

    /**
     * Constructeur de la classe Infos.
     *
     * @param jeu Le jeu pour lequel cette instance d'Infos agit comme observateur.
     */
    public Infos(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.initCoeurs();

        this.setMinHeight(40);
        this.setPrefHeight(40);
        this.setMaxHeight(40);

        Tooltip.install(this, new Tooltip("Nombre de coeurs restants"));
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

        if(this.jeu.getNbVies() == 0) { return; }

        for (int i = 0; i < this.jeu.getNbVies(); i++) {
            ImageView coeur = new ImageView();
            coeur.setImage(new Image(Objects.requireNonNull(getClass().getResource("/coeur.png")).toExternalForm()));
            coeur.setFitWidth(30);
            coeur.setPreserveRatio(true);

            this.getChildren().add(coeur);
        }
    }

}
