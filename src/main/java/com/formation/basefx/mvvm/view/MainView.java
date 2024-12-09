package com.formation.basefx.mvvm.view;

import com.formation.basefx.mvvm.viewmodel.PersonViewModel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

    private PersonViewModel viewmodel;

    public MainView(PersonViewModel viewmodel) {
        this.viewmodel = viewmodel;
    }

    public void start(Stage stage) {
        // Champ de texte pour le prénom (puis pour le nom) relié de manière bidirectionnelle à la propriété du ViewModel
        TextField firstNameField = new TextField();
        firstNameField.textProperty().bindBidirectional(viewmodel.firstNameProperty());
        TextField lastNameField = new TextField();
        lastNameField.textProperty().bindBidirectional(viewmodel.lastNameProperty());

        Button button = new Button("Enregistrer");
        button.setOnAction(e -> viewmodel.saveChanges());

        VBox layout = new VBox(10, firstNameField, lastNameField, button);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color:teal");

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("MVVM Example");
        stage.show();
    }
}
