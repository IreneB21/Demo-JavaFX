package com.formation.basefx.composant;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MyChoiceBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie une HBox
        HBox root = new HBox(10);
        // On instancie un label
        Label lbl = new Label();

        // On instancie une ChoiceBox
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        // On ajoute dans la ChoiceBox les valeurs disponibles pour l'utilisateur
        choiceBox.getItems().addAll("Villes", "Paris", "Ouagadougou", "Toronto", "Singapour");
        //On définit la valeur par défaut de la ChoiceBox:
        choiceBox.getSelectionModel().select(0);

        //On ajoute la ChoiceBox et le Label à la liste de Nodes enfants du panel root
        root.getChildren().addAll(choiceBox, lbl);

        // On stylise notre panneau
        root.setStyle("-fx-background-color:cyan");
        root.setAlignment(Pos.CENTER);

        // On instancie une scène en lui donnant le panneau root et des dimensions
        Scene scene = new Scene(root, 500, 100);
        // On donne la scène à notre Stage
        stage.setScene(scene);

        // On donne un titre à notre Stage
        stage.setTitle("Première ChoiceBox");
        // On ajuste la taille du Stage en fonction de la dimension de la scène
        stage.sizeToScene();
        // On affiche notre Stage
        stage.show();

        /*
        On ajoute un listener sur la propriété de sélection de notre ChoiceBox grâce à une classe anonyme
        de ChangeListener<String>(). A chaque fois que la valeur sélectionnée de la ChoiceBox changera,
        l'évènement sera déclenché. C'est le principe d'un listener : il écoute le changement d'une propriété
        et déclenche un événement lorsque cette propriété est modifiée.
         */
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    // Lorsque l'évènement est déclenché, on écrit dans le label l'ancienne valeur et la nouvelle valeur de la ChoiceBox
                    lbl.setText(oldValue + " => " + newValue);
                }
            }
        });
    }
}
