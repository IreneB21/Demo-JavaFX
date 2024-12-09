package com.formation.basefx.vvm;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class AdvanceChoiceBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // On instancie une HBox
        HBox root = new HBox(10);

        // On instancie un bouton et un label
        Button btn = new Button("Valider");
        Label lbl = new Label();

        // On instancie un CharacterDAO pour pouvoir accéder aux données
        CharacterDAO dao = new CharacterDAO();

        /*
         On instancie une liste observable en utilisant la méthode observableArrayList() de l'objet FXCollections
         à laquelle on transmet en paramètre la méthode getCharacters() de notre DAO. Cette liste est bindée à notre modèle.
         Il faut désormais la binder à un composant de notre vue.
         */
        ObservableList<Character> observableCharacters = FXCollections.observableArrayList(dao.getCharacters());
        /*
         On instancie une ComboBox. Ce composant est le même qu'une ChoiceBox, mais permet d'afficher davantage d'options
         et possède donc plus de propriétés. On binde cette ComboBox à notre liste observable de Characters
         en transmettant la liste au constructeur de la ComboBox.
         */
        ComboBox<Character> cb = new ComboBox<>(observableCharacters);

        // On choisit une valeur affichée par défaut dans la ComboBox
        cb.setPromptText("Personnages");

        // La ComboBox est faite pour recevoir beaucoup de valeurs.
        // On peut donc restreindre l'affichage au nombre de valeurs souhaitées.
        cb.setVisibleRowCount(4);

        // Pour un affichage plus élégant, on utilise un Converter, afin de n'afficher
        // que le nom et le prénom de nos personnages dans la ComboBox.
        cb.setConverter(new StringConverter<Character>() {
            @Override
            public String toString(Character character) {
                // TODO Auto-generated method stub
                return String.format("%s %s", character.getFirstname(), character.getLastname());
            }

            @Override
            public Character fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        });

        // On stylise notre panel root
        root.setStyle("-fx-background-color:teal");
        root.setAlignment(Pos.CENTER);

        // On ajoute la ComboBox, le bouton et le label à la liste des Nodes enfants de notre panel root
        root.getChildren().addAll(cb, btn, lbl);

        // On instancie une scène en lui donnant le panneau root et des dimensions
        Scene scene = new Scene(root, 700, 100);
        // On donne la scène à notre Stage
        stage.setScene(scene);
        // On donne un titre à notre Stage
        stage.setTitle("Première ChoiceBox avec données");
        // On dimensionne le Stage en fonction de la scène affichée
        stage.sizeToScene();
        // On affiche notre Stage
        stage.show();

        // On déclenche un évènement lorsque le bouton est cliqué
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // On récupère le personnage sélectionné par l'utilisateur
                Character character = cb.getSelectionModel().getSelectedItem();
                // On affiche les infos du personnage sélectionné dans le label
                lbl.setText(character.toString());
            }
        });
    }
}
