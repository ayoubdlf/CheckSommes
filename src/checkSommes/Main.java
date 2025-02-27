package checkSommes;

import checkSommes.ig.*;
import checkSommes.modele.Jeu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        Jeu jeu = new Jeu();

        root.setBottom(new PanneauDeControle(jeu));

        stage.setTitle("Casse-tête de nombres");
        stage.setScene(new Scene(root, 500, 450));
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}