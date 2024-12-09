package com.formation.basefx;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Ma première application JavaFX");
        // On affiche le Stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}