package checkSommes;

import checkSommes.ig.*;
import checkSommes.modele.Jeu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        Jeu jeu = new Jeu();

        VBox rightPanel = new VBox();
        rightPanel.getChildren().add(new Infos(jeu));

        root.setBottom(new PanneauDeControle(jeu));
        root.setRight(rightPanel);


        stage.setTitle("Casse-tête de nombres");
        stage.setScene(new Scene(root, 500, 450));
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}