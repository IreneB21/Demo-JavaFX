package com.formation.basefx.composant;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyRadioButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie une HBox
        HBox root = new HBox(10);

        // On instancie des RadioButtons et un Label
        RadioButton rb1 = new RadioButton("Masculin");
        RadioButton rb2 = new RadioButton("Féminin");
        RadioButton rb3 = new RadioButton("Indéterminé");
        Label lbl = new Label();
        lbl.setTextFill(Color.RED);

        // On lie entre eux les RadioButtons au sein d'un ToggleGroup afin de ne permettre qu'à un seul d'entre eux d'être coché
        ToggleGroup grp = new ToggleGroup();
        grp.getToggles().addAll(rb1, rb2, rb3);

        // On ajoute les RadioButtons et le Label à la liste de Nodes enfant du panel root
        root.getChildren().addAll(rb1, rb2, rb3, lbl);

        // On stylise le panel root
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color:cyan");

        // On instancie une scène en lui donnant le panneau root et des dimensions
        Scene scene = new Scene(root, 550, 100);
        // On donne la scène à notre Stage
        stage.setScene(scene);
        // On donne un titre à notre Stage
        stage.setTitle("Premier Radio Button");
        // On ajuste la taille du stage en fonction de la dimension de la scène
        stage.sizeToScene();
        // On affiche notre Stage
        stage.show();

        // Pour gérer l'évènement, on programme un listener directement sur le ToggleProperty du ToggleGroup
        grp.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                // Le cast en Labeled permet de récupérer la valeur du RadioButton coché
                Labeled itemSelected = (Labeled) newValue;
                // On donne au label le texte "changement => valeur du RadioButton coché"
                lbl.setText("changement => " + itemSelected.getText());
            }
        });
    }
}
