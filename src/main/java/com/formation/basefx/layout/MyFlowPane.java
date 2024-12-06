package com.formation.basefx.layout;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MyFlowPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws  Exception {
        // On instancie un FlowPane :
        FlowPane root = new FlowPane();

        // On instancie des boutons :
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        Button btn4 = new Button("Bouton 4");
        Button btn5 = new Button("Bouton 5");
        Button btn6 = new Button("Bouton 6");
        Button btn7 = new Button("Bouton 7");
        Button btn8 = new Button("Bouton 8");

        // On ajoute ces boutons à la liste de Nodes enfants du FlowPane :
        root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);

        // On stylise le fond du FlowPane :
        root.setStyle("-fx-background-color:blue");

        // On définit l'axe sur lequel on souhaite organiser les Nodes enfants du FlowPane (horizontal ou vertical) :
        root.setOrientation(Orientation.VERTICAL);

        // On instancie notre scène en lui donnant notre panneau root :
        Scene scene = new Scene(root);

        // On donne un titre à notre Stage :
        stage.setTitle("Premier FlowPane");

        // On donne notre scène à notre Stage :
        stage.setScene(scene);

        // On affiche notre Stage :
        stage.show();
    }
}
