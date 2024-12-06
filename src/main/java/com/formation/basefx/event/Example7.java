package com.formation.basefx.event;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class Example7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(50);
        stage.setTitle("Interaction avec l'utilisateur");

        Label label = new Label();
        label.setTextFill(Color.hsb(270,1.0,1.0));
        label.setFont(Font.font("Brush Script MT", 35));
        label.relocate(300, 450);
        Button button = new Button("Afficher");
        button.setOnAction(e -> label.setText("Hello Wordl !"));

        root.setAlignment(Pos.CENTER);
        root.getChildren().add(button);
        root.getChildren().add(label);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);

        stage.show();
    }
}
