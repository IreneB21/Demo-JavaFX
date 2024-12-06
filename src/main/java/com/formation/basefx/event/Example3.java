package com.formation.basefx.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class Example3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        stage.setTitle("Interaction avec l'utilisateur");

        Button button = new Button("Afficher");
        Button cancel = new Button("Annuler");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Hola mundo !");
            }
        };

        button.setOnAction(handler);
        cancel.setOnAction(handler);
        root.getChildren().add(button);
        root.getChildren().add(cancel);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);

        stage.show();
    }
}
