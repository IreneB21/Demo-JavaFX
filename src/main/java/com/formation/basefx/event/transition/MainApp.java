package com.formation.basefx.event.transition;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // On redéfinit la méthode start de la classe Application
    @Override
    public void start(Stage stage) throws Exception {

        // On instancie notre scène en lui donnant notre panneau root
        FirstPan root = new FirstPan();
        // On instancie notre scène en lui donnant notre panneau root
        Scene scene = new Scene(root);
        // On donne notre scène à notre Stage
        stage.setScene(scene);
        stage.setTitle("Première Transition");
        // On demande à notre Stage de s'adapter à la taille de la scène
        stage.sizeToScene();
        // On affiche notre Stage
        stage.show();
    }
}
