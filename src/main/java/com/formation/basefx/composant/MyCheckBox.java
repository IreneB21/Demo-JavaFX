package com.formation.basefx.composant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyCheckBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie une VBox
        VBox root = new VBox(20);

        // On instancie deux labels et un bouton
        Label label1 = new Label("Choisissez vos personnages préférés");
        Label label2 = new Label();
        Button button = new Button("Valider");

        // On instancie des CheckBox
        CheckBox oberyn = new CheckBox("Oberyn");
        CheckBox doran = new CheckBox("Doran");
        CheckBox eddard = new CheckBox("Eddard");
        CheckBox tyrion = new CheckBox("Tyrion");
        CheckBox jon = new CheckBox("Jon");

        // On regroupe nos CheckBox dans un tableau afin de gérer facilement l'évènement
        final CheckBox[] boxes = {oberyn, doran, eddard, tyrion, jon};

        // On ajoute nos composants à la liste de Nodes enfant de notre panel root
        root.getChildren().addAll(boxes);
        root.getChildren().addAll(button, label1, label2);

        // On stylise le panneau
        root.setStyle("-fx-background-color:cyan");
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        // On instancie une scène en lui donnant le panneau root et des dimensions
        Scene scene = new Scene (root, 500, 500);
        // On donne la scène à notre Stage
        stage.setScene(scene);
        // On donne un titre à notre Stage
        stage.setTitle("Première Checkbox");
        // On ajuste la taille du Stage en fonction de la dimension de la scène
        stage.sizeToScene();
        // On affiche notre Stage
        stage.show();

        // On déclenche un événement quand l'utilisateur clique sur le bouton
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // On instancie un StringBuilder pour récupérer les éléments cochés
                StringBuilder builder = new StringBuilder();
                // Pour chaque box
                for (CheckBox box : boxes) {
                    // Si la box est cochée
                    if (box.isSelected()) {
                        // On ajoute la valeur de la box à notre builder
                        builder.append(String.format("\t%s%n ", box.getText()));
                    }
                    // Si aucune box n'est cochée
                }
                if (builder.length() == 0) {
                    builder.append("Vous n'avez rien choisi\n");
                }
                // Autrement, on ajoute au tout début du builder la phrase suivante :
                else {
                    builder.insert(0, "Vos personnages préférés sont :\n ");
                }

                // Enfin, on affiche dans le label la contenu de notre StringBuilder
                label2.setText(builder.toString());
            }
        });

    }
}
