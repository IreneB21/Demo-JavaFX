package com.formation.basefx.exercices.exo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie le MainPanel
        MainPanel mainPanel = new MainPanel();

        // On instancie la scène
        Scene scene = new Scene(mainPanel, 600, 400);
        // On donne la scène à notre Stage :
        stage.setScene(scene);

        // On donne un titre à notre Stage :
        stage.setTitle("TP Évènement");

        // On affiche notre Stage :
        stage.show();
    }
}
