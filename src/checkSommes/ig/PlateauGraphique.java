package checkSommes.ig;

import checkSommes.modele.Jeu;
import checkSommes.utils.Couleur;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class PlateauGraphique extends GridPane implements Observateur {

    private Jeu jeu;

    /**
     * Constructeur de la classe PlateauGraphique.
     * 
     * @param jeu Le modèle de jeu associé à ce plateau graphique.
     */
    public PlateauGraphique(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.initPlateau();

        this.setAlignment(Pos.CENTER);
    }

    /**
     * Méthode appelée pour réagir aux changements dans le modèle de jeu.
     * Si le jeu est terminé, affiche un dialogue et réinitialise le plateau.
     */
    public void reagir() {
        if(this.jeu.jeuTermine()) {
            this.showDialogue();
        }

        this.initPlateau();

        Tooltip.install(this, new Tooltip("Plateau de jeu"));
    }

    /**
     * Affiche un dialogue indiquant que le jeu est terminé.
     */
    private void showDialogue() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Jeu termine");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez terminé le jeu");

        alert.showAndWait()
            .filter(response -> response == ButtonType.OK)
            .ifPresent(response -> this.jeu.reinitialiserPlateau());
    }

    /**
     * Initialise les labels affichant les sommes des lignes et des colonnes.
     */
    private void initLabelSommes() {
        for (int ligne = 0; ligne < this.jeu.getNbLignes(); ligne++) {
            String sommeLigne = Integer.toString(this.jeu.sommeLigne(ligne));
            Label label       = new Label(sommeLigne);

            this.add(label, 0, ligne+1);

            GridPane.setHalignment(label, HPos.CENTER);
            label.alignmentProperty().set(Pos.CENTER);
            label.setMinWidth(40);
            label.setMinHeight(40);
        }

        for (int colonne = 0; colonne < this.jeu.getNbColonnes(); colonne++) {
            String sommeColonne = Integer.toString(this.jeu.sommeColonne(colonne));
            Label label         = new Label(sommeColonne);

            this.add(label, colonne+1, 0);

            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setValignment(label, VPos.CENTER);
            label.alignmentProperty().set(Pos.CENTER);
            label.setMinWidth(40);
            label.setMinHeight(40);
        }
    }

    /**
     * Initialise le plateau de jeu en ajoutant les boutons et les labels.
     */
    private void initPlateau() {
        this.getChildren().clear();

        this.initLabelSommes();

        for (int ligne = 0; ligne < this.jeu.getNbLignes(); ligne++) {
            for (int colonne = 0; colonne < this.jeu.getNbColonnes(); colonne++) {
                String valeurCase   = Integer.toString(this.jeu.getValeur(ligne, colonne));
                int couleurCase     = this.jeu.getCouleur(ligne, colonne);
                final int nbLigne   = ligne;    // on a besoin de `final` pour faire appel à la fonction lambda du button onAction
                final int nbColonne = colonne;  // on a besoin de `final` pour faire appel à la fonction lambda du button onAction

                Button button = new Button(valeurCase);
                button.setOnAction(e -> {
                    if(!this.jeu.jeuTermine()) {
                        this.jeu.choisirCase(nbLigne, nbColonne);
                    }
                });

                button.setBackground(new Background(new BackgroundFill(Couleur.getCouleur(couleurCase), new CornerRadii(4), new Insets(2))));
                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);

                this.add(button, colonne+1, ligne+1); // +1 parce qu'il y'a les labels des sommes des lignes et colonnes
                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);
            }
        }
    }

}
