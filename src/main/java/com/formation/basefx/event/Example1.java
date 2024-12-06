package com.formation.basefx.event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Example1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        stage.setTitle("Interaction avec l'utilisateur");

        Button button = new Button("Afficher");
        button.setOnAction(new Action());
        root.getChildren().add(button);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);

        stage.show();
    }
}
