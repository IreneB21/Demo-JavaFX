package com.formation.basefx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyAnchorPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie un AnchorPane :
        AnchorPane root = new AnchorPane();

        // On instancie un panel que l'on stylise :
        Pane panel = new Pane();
        panel.setStyle("-fx-background-color:teal");

        // On ajoute le panel à la liste de Nodes enfants de l'AnchorPane :
        root.getChildren().add(panel);

        // On définit les ancres de chaque côté :
        AnchorPane.setTopAnchor(panel, 10.);
        AnchorPane.setBottomAnchor(panel, 10.);
        AnchorPane.setLeftAnchor(panel, 10.);
        AnchorPane.setRightAnchor(panel, 10.);

        // On instancie notre scène en lui donnant notre panel root et des dimensions :
        Scene scene = new Scene(root, 400, 400);

        // On donne un titre à notre Stage :
        stage.setTitle("Mon premier AnchorPane");

        // On donne notre scène à notre Stage :
        stage.setScene(scene);

        // On affiche notre stage :
        stage.show();
    }
}
