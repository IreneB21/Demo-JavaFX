package com.formation.basefx.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class Example5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        stage.setTitle("Interaction avec l'utilisateur");

        Button button1 = new Button("Afficher Old");
        Button button2 = new Button("Afficher New");

        EventHandler<ActionEvent> oldHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Salut !");
            }
        };

        EventHandler<ActionEvent> newHandler = e -> JOptionPane.showMessageDialog(null, "Coucou !");

        button1.setOnAction(oldHandler);
        button2.setOnAction(newHandler);
        root.getChildren().add(button1);
        root.getChildren().add(button2);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);

        stage.show();
    }
}
