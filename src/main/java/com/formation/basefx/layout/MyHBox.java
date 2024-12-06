package com.formation.basefx.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyHBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*
        Le constructeur de la HBox peut prendre en paramètre un double qui
        correspond à l'espacement en pixel de ses Node enfants sur l'axe horizontal :
        */
        javafx.scene.layout.HBox root = new javafx.scene.layout.HBox(30);

        // On instancie des boutons :
        Button btn1 = new Button("OK");
        btn1.setTextFill(Color.BLUE);
        btn1.setStyle("-fx-background-color:red");
        Button btn2 = new Button("Annuler");
        Button btn3 = new Button("Bombe H");

        // On ajoute ces boutons à la liste de Nodes enfants de la HBox :
        root.getChildren().addAll(btn1, btn2, btn3);

        // On centre les Nodes enfants dans la HBox :
        root.setAlignment(Pos.CENTER);

        // On stylise le fond de la HBox :
        root.setStyle("-fx-background-color:cyan");

        // On dimensionne notre panneau en fonction de la scène :
        stage.sizeToScene();

        // On interdit le redimensionnement du Stage :
        stage.setResizable(false);

        // On instancie une scène en lui donnant un panneau racine et des dimensions :
        Scene scene = new Scene(root, 400, 100);

        // On donne un titre à notre Stage :
        stage.setTitle("Première HBox");

        // On donne notre scène à notre Stage :
        stage.setScene(scene);

        // On affiche notre Stage :
        stage.show();
    }
}
