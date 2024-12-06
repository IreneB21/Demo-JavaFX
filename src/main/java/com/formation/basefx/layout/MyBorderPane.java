package com.formation.basefx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyBorderPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie un BorderPane :
        BorderPane root = new BorderPane();

        // On instancie et on stylise des Labels et des Panes qui seront contenus par notre BorderPane :
        Label labelBottom = new Label("Label d'en bas");
        Label labelRight = new Label("Label de droite");
        Label labelCenter = new Label("Label du centre");
        Pane topPanel = new Pane();
        topPanel.setPrefSize(800, 100);
        topPanel.setStyle("-fx-background-color:blue");
        Pane leftPanel = new Pane();
        leftPanel.setPrefSize(200, 700);
        leftPanel.setStyle("-fx-background-color:teal");

        // On positionne nos différents éléments dans le BorderPane :
        root.setTop(topPanel);
        root.setBottom(labelBottom);
        root.setRight(labelRight);
        root.setLeft(leftPanel);
        root.setCenter(labelCenter);

        // On instancie notre scène en lui donnant notre panel root et des dimensions :
        Scene scene = new Scene(root, 800, 800);

        // On donne un titre à notre Stage :
        stage.setTitle("Mon premier BorderPane");

        // On donne notre scène à notre Stage :
        stage.setScene(scene);

        // On affiche notre Stage :
        stage.show();
    }
}
