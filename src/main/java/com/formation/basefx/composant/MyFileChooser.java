package com.formation.basefx.composant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MyFileChooser extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie une VBox
        VBox root = new VBox(5);

        // On instancie un bouton et un label.
        Button button = new Button("Ouvrir");
        Label label = new Label();

        // On ajoute le bouton et le label à la liste de Nodes enfant du panel root
        root.getChildren().addAll(button, label);

        // On stylise le panel root
        root.setStyle("-fx-background-color:teal");
        root.setAlignment(Pos.CENTER);

        // On instancie une scène en lui donnant le panneau root et des dimensions
        Scene scene = new Scene(root, 400, 200);
        // On donne la scène à notre Stage
        stage.setScene(scene);
        // On donne un titre à notre Stage
        stage.setTitle("Premier File Chooser");
        // On affiche notre Stage
        stage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // On instancie un FileChooser
                FileChooser fileChooser = new FileChooser();
                // On instancie un File en transmettant à son constructeur le répertoire par défaut à ouvrir
                File initDir = new File("C:\\Users\\Formation");
                // On donne au FileChooser ce répertoire par défaut
                fileChooser.setInitialDirectory(initDir);
                // On ouvre une fenêtre contextuelle pour permettre à l'utilisateur de choisir le fichier à ouvrir
                File f = fileChooser.showOpenDialog(stage.getOwner());

                if (f != null) {
                    // Si l'utilisateur a bien sélectionné un fichier, on récupère dans le label son chemin absolu
                    label.setText(f.getAbsolutePath());
                }
            }
        });
    }
}
