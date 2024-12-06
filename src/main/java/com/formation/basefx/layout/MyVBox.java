package com.formation.basefx.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyVBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*
        Le constructeur de la VBox peut prendre en paramètre un double qui
        correspond à l'espacement en pixel de ses Node enfants sur l'axe vertical :
        */
        VBox root = new VBox(30);

        // On instancie des boutons :
        Button btn1 = new Button("OK");
        btn1.setTextFill(Color.BLUE);
        btn1.setStyle("-fx-background-color:red");
        Button btn2 = new Button("Annuler");
        Button btn3 = new Button("Bombe H");

        // On ajoute ces boutons à la liste des Nodes enfants de la VBox :
        root.getChildren().addAll(btn1, btn2, btn3);

        // On centre les Nodes enfants dans la VBox :
        root.setAlignment(Pos.CENTER);

        // On stylise le fond de la VBox :
        root.setStyle("-fx-background-color:cyan");

        // On interdit le redimensionnement du Stage :
        stage.setResizable(false);

        // On instancie une scène en lui donnant un panneau racine et des dimensions :
        Scene scene = new Scene(root, 400, 250);

        // On donne un titre à notre Stage :
        stage.setTitle("Première VBox");

        // On donne notre Stage à notre scène :
        stage.setScene(scene);

        // On affiche notre Stage :
        stage.show();
    }
}
