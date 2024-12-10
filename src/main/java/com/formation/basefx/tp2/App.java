package com.formation.basefx.tp2;

import com.formation.basefx.tp2.model.ShowsList;
import com.formation.basefx.tp2.model.TVShow;
import com.formation.basefx.tp2.view.Form;
import com.formation.basefx.tp2.view.Table;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    private ShowsList shows = new ShowsList();

    @Override
    public void start(Stage stage) throws Exception {
        TableView<TVShow> table = new TableView<TVShow>();
        HBox hbMain = new HBox();
        Form form = new Form(shows, table);
        Table bpTable = new Table(shows, table);
        hbMain.getChildren().addAll(form, bpTable);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            form.getTfTitle().setText(newSelection.getTitle());
            form.getTfSeasons().setText(newSelection.getNumberSeasons().toString());
            form.getTfYear().setText(newSelection.getYear().toString());
            form.getTfCompany().setText(newSelection.getCompany());
            form.getTfScore().setText(newSelection.getScore().toString());
        });

        Scene scene = new Scene(hbMain, 1300, 650);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
Réalisez une application en JavaFX de notation de séries télévisées dont les données sont persistées dans un
fichier CSV. L'application doit implémenter les fonctionnalités suivantes :
Enregistrer et noter une série télévisée
Mettre à jour une série télévisée
Effacer une série télévisée
 */
