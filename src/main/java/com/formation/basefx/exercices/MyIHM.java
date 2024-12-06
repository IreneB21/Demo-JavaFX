package com.formation.basefx.exercices;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyIHM extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie un BorderPane
        BorderPane root = new BorderPane();

        String border = "-fx-border-color: black;\n" +
                "-fx-border-width: 1.8;\n" +
                "-fx-border-style: solid;\n";

        // On instancie la HBox (haut du Panel) :
        HBox rootHBox = new HBox(70);
        // On instancie des boutons :
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        Button btn4 = new Button("Bouton 4");
        // On ajoute ces boutons à la liste de Nodes enfants de la HBox :
        rootHBox.getChildren().addAll(btn1, btn2, btn3, btn4);
        // On centre les Nodes enfants dans la HBox :
        rootHBox.setAlignment(Pos.CENTER);
        // On stylise la HBox :
        rootHBox.setStyle("-fx-background-color:red;" + border);
        rootHBox.setPrefSize(800, 80);

        // On instancie la VBox (gauche du Panel) :
        VBox rootVBox = new VBox(60);
        // On instancie des labels :
        Label label1 = new Label("label 1");
        Label label2 = new Label("label 2");
        Label label3 = new Label("label 3");
        Label label4 = new Label("label 4");
        // On ajoute ces boutons à la liste des Nodes enfants de la VBox :
        rootVBox.getChildren().addAll(label1, label2, label3, label4);
        // On stylise la VBox :
        rootVBox.setAlignment(Pos.CENTER);
        rootVBox.setStyle("-fx-background-color:green");
        rootVBox.setPrefSize(120, 500);

        Pane rightPanel = new Pane();
        rightPanel.setPrefSize(680, 500);
        rightPanel.setStyle("-fx-background-color:teal");

        // On positionne les différents éléments dans le BorderPane :
        root.setTop(rootHBox);
        root.setLeft(rootVBox);
        root.setRight(rightPanel);

        // Evènements :
        btn1.setOnAction(e -> label1.setText("Hello !"));
        btn2.setOnAction(e -> label2.setText("How are you today ?"));
        btn3.setOnAction(e -> label3.setText("Great to see you !"));
        btn4.setOnAction(e -> label4.setText("Bye !"));

        // On instancie notre scène :
        Scene scene = new Scene(root, 800, 600);

        // On donne un titre à notre Stage :
        stage.setTitle("Mon premier IHM");

        // On donne notre scène à notre Stage :
        stage.setScene(scene);

        // On affiche notre Stage :
        stage.show();
    }
}

