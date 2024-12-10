package com.formation.basefx.tp2.view;

import com.formation.basefx.tp2.model.ShowsList;
import com.formation.basefx.tp2.model.TVShow;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class Table extends BorderPane {

    public Table(ShowsList shows, TableView<TVShow> table) {
        super();

        table.setEditable(false);

        // Création des colonnes
        TableColumn<TVShow, String> titleCol = new TableColumn<>("Titre");
        titleCol.setMinWidth(250);
        titleCol.setCellValueFactory(new PropertyValueFactory<TVShow, String>("title"));

        TableColumn<TVShow, String> seasonsCol = new TableColumn<>("Nombre de saisons");
        seasonsCol.setMinWidth(150);
        seasonsCol.setCellValueFactory(new PropertyValueFactory<TVShow, String>("numberSeasons"));

        TableColumn<TVShow, String> yearCol = new TableColumn<>("Année de sortie");
        yearCol.setMinWidth(150);
        yearCol.setCellValueFactory(new PropertyValueFactory<TVShow, String>("year"));

        TableColumn<TVShow, String> compCol = new TableColumn<>("Maison de production");
        compCol.setMinWidth(150);
        compCol.setCellValueFactory(new PropertyValueFactory<TVShow, String>("company"));

        TableColumn<TVShow, String> scoreCol = new TableColumn<>("Votre note");
        scoreCol.setMinWidth(150);
        scoreCol.setCellValueFactory(new PropertyValueFactory<TVShow, String>("score"));

        table.getColumns().addAll(titleCol, seasonsCol, yearCol, compCol, scoreCol);

        // On remplit la table avec la liste observable
        table.setItems(shows.getShows());

        this.setCenter(table);
    }
}
