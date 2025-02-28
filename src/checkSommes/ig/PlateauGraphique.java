package checkSommes.ig;

import checkSommes.modele.Jeu;
import checkSommes.utils.Couleur;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class PlateauGraphique extends GridPane implements Observateur {

    private Jeu jeu;

    public PlateauGraphique(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.initPlateau();

        this.setAlignment(Pos.CENTER);
    }

    public void reagir() {
        if(this.jeu.jeuTermine()) {
            this.showDialogue();
            this.jeu.reinitialiserPlateau();
        }
        this.initPlateau();
    }

    private void showDialogue() {
        Dialog<String> dialog = new Dialog<>();

        dialog.setTitle("Jeu termine");
        dialog.setContentText("Vous avez terminé le jeu");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);

        dialog.showAndWait();
    }

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
                button.setOnAction(e -> this.jeu.choisirCase(nbLigne, nbColonne));

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
