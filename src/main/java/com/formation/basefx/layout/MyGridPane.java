package com.formation.basefx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyGridPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie un GridPane :
        GridPane root = new GridPane();

        // On instancie des Labels, des TextFields et un Button afin de constituer un formulaire :
        Label labelLastName = new Label("Nom : ");
        TextField txtLastName = new TextField();
        Label labelFirstName = new Label("Prénom : ");
        TextField txtFirstName = new TextField();
        Label labelAge = new Label("Age : ");
        TextField txtAge = new TextField();
        Label labelAddress = new Label("Adresse : ");
        TextField txtAddress = new TextField();
        Button btn = new Button("Valider");

        // On ajoute des Nodes enfants au GridPane à partir de coordonnées avec add(nomComposant, colonne, ligne) :
        // root.add(labelLastName, 0, 0);
        // root.add(txtLastName, 1, 0);
        // root.add(labelFirstName, 2, 0);
        // root.add(txtLastName, 3, 0);
        // root.add(labelAge, 0, 1);
        // root.add(txtAge, 1, 1);
        // root.add(labelAddress, 2, 1);
        // root.add(txtAddress, 3, 1);
        // root.add(btn, 0,2);

        // On peut aussi ajouter plusieurs Nodes enfants sur une même ligne grâce à la méthode addRow() :
        root.addRow(0, labelLastName, txtLastName, labelFirstName, txtFirstName);
        root.addRow(1, labelAddress, txtAddress, labelAge, txtAge);
        root.addRow(3, btn);

        // On ajoute un peu de padding au panneau :
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setStyle("-fx-background-color:pink");

        // On peut gérer l'espacement horizontal des Nodes enfants avec Hgap() et l'espacement vertical avec Vgap() :
        root.setVgap(10);
        root.setHgap(10);

        // On donne un titre à notre Stage :
        stage.setTitle("Mon premier GridPane");

        // On instancie notre scène en lui donnant notre panneau racine :
        Scene scene = new Scene(root);

        // On donne à notre Stage notre scène :
        stage.setScene(scene);

        // On affiche notre Stage :
        stage.show();
    }
}
