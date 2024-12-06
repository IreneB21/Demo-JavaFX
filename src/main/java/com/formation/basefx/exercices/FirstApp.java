package com.formation.basefx.exercices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstApp extends Application {

    // Dans le main, on démarre le Thread Java FX Application :
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Instanciation d'un premier panneau (le Pane est le panneau le plus basique de JavaFX) :
        Pane root = new Pane();
        // On instancie une scène à laquelle on donne notre panneau et des dimensions :
        Scene scene = new Scene(root, 500, 500);
        // On donne à notre Stage notre scène :
        stage.setScene(scene);

        // On donne un titre à notre stage :
        stage.setTitle("Ma première application");

        // On dimensionne notre panneau en fonction de la scène
        stage.sizeToScene();
        // On interdit le redimensionnement de la fenêtre :
        stage.setResizable(false);
        // On stylise notre panneau :
        root.setStyle("-fx-background-color:cyan");

        // On instancie des objets à afficher sur le panneau, on les stylise et on les positionne :
        Circle cercle = new Circle(75);
        cercle.setFill(Color.YELLOW);
        cercle.setStroke(Color.ORANGE);
        cercle.relocate(50, 50);

        Rectangle rectangle = new Rectangle(500, 150);
        rectangle.setFill(Color.GREEN);
        rectangle.setStroke(Color.DARKGREEN);
        rectangle.relocate(0, 350);

        Label label = new Label("Mon bo dessin");
        label.setTextFill(Color.HOTPINK);
        label.setFont(Font.font("Brush Script MT", 35));
        label.relocate(300, 450);

        // On donne nos éléments graphiques à notre panneau :
        root.getChildren().add(cercle);
        root.getChildren().add(rectangle);
        root.getChildren().add(label);

        // On affiche notre stage :
        stage.show();
    }
}
