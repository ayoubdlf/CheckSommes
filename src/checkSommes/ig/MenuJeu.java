package checkSommes.ig;

import checkSommes.modele.Jeu;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;


public class MenuJeu extends MenuBar implements Observateur {

    private Jeu jeu;

    public MenuJeu(Jeu jeu) {
        this.jeu = jeu;
        this.jeu.ajouterObservateur(this);

        this.initMenuJeu();
    }

    private void initMenuJeu() {
        Menu menuFichier = new Menu("Fichier");

        MenuItem recommencer = new MenuItem("Recommencer le jeu");
        MenuItem ouvrir      = new MenuItem("Ouvrir un fichier");
        MenuItem quitter     = new MenuItem("Quitter le jeu");

        recommencer.setOnAction(e -> this.jeu.reinitialiserPlateau());
        quitter.setOnAction(e -> Platform.exit());
        ouvrir.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Ouvrir un fichier");

            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichiers texte", "*.txt"));

            File fichier = fileChooser.showOpenDialog(this.getScene().getWindow());

            try {
                this.jeu.ouvrir(fichier);
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur lors de l'ouverture du fichier");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });

        menuFichier.getItems().addAll(recommencer, ouvrir, quitter);

        this.getMenus().addAll(menuFichier);
    }

    /**
     * Méthode appelée pour réagir aux changements dans le jeu.
     */
    public void reagir() {}
}
