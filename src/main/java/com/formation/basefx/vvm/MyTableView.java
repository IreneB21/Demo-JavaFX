package com.formation.basefx.vvm;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyTableView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) throws Exception {
        // On instancie un BorderPane comme panneau root
        BorderPane root = new BorderPane();
        // On instancie un AnchorPane pour contenir notre TableView
        AnchorPane anchorPane = new AnchorPane();

        // On instancie un CharacterDAO pour pouvoir accéder à nos données
        CharacterDAO dao = new CharacterDAO();

        /*
         On instancie une liste observable en utilisant la méthode observableArrayList() de l'objet FXCollections
         à laquelle on transmet en paramètre la méthode getPersonnages() de notre DAO. Cette liste est bindée à notre modèle.
         Il faut désormais la binder à un composant de notre vue.
         */
        ObservableList<Character> observableCharacters = FXCollections.observableArrayList(dao.getCharacters());

        // On instancie une TableView que l'on binde à notre liste observable
        TableView<Character> tableView = new TableView<>(observableCharacters);

        // On instancie une colonne pour notre TableView
        TableColumn<Character, String> colLastName = new TableColumn<>("Nom");
        // On transmet le nom du personnage à la colonne
        colLastName.setCellValueFactory(new PropertyValueFactory<Character, String>("lastname"));
        // On fait la même chose pour les autres colonnes en les associant chacune à un attribut de nos personnages
        TableColumn<Character, String> colFirstName = new TableColumn<>("Prénom");
        colFirstName.setCellValueFactory(new PropertyValueFactory<Character, String>("firstname"));
        TableColumn<Character, Integer> colAge = new TableColumn<>("Age");
        colAge.setCellValueFactory(new PropertyValueFactory<Character, Integer>("age"));

        // On donne les colonnes au TableView
        tableView.getColumns().addAll(colLastName, colFirstName, colAge);

        // On équilibre les colonnes du tableau afin qu'il prenne toute la place disponible
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // On ajoute le TableView à la liste de Nodes enfant de l'AnchorPane
        anchorPane.getChildren().add(tableView);

        // On définit la taille de l'AnchorPane et de ses ancres
        anchorPane.setPrefSize(300, 200);
        AnchorPane.setTopAnchor(tableView, 5.);
        AnchorPane.setLeftAnchor(tableView, 5.);
        AnchorPane.setRightAnchor(tableView, 5.);
        AnchorPane.setBottomAnchor(tableView, 5.);

        // On instancie une VBox
        VBox vBox = new VBox();

        // On instancie deux labels
        Label lbl1 = new Label("Personnage sélectionné");
        Label lbl2 = new Label();

        // On ajoute du padding au premier label
        lbl1.setPadding(new Insets(0, 70, 0, 0));

        // On ajoute les deux labels à la liste de Nodes enfants de la Vbox
        vBox.getChildren().addAll(lbl1, lbl2);

        // On stylise la VBox
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefWidth(600);

        // On place l'AnchorPane à gauche et la VBox à droite dans notre panel root
        root.setLeft(anchorPane);
        root.setRight(vBox);

        // On donne une couleur de fond au panel root
        root.setStyle("-fx-background-color:#0099ff");

        // On instancie une scène en lui donnant le panneau root et des dimensions
        Scene scene = new Scene(root, 800, 400);
        // On donne la scène à notre Stage
        stage.setScene(scene);
        // On donne un titre à notre Stage
        stage.setTitle("Première TableView");
        // On affiche notre Stage
        stage.show();

        // On ajoute un listener qui récupère la personne sélectionnée dans le tableau
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Character>() {
            @Override
            public void changed(ObservableValue<? extends Character> observable, Character oldValue, Character newValue) {
                // On affiche les attributs du personnage sélectionné dans le label
                lbl2.setText(newValue.toString());
            }
        });
    }
}
