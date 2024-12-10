package com.formation.basefx.tp2.view;

import com.formation.basefx.tp2.model.ShowsList;
import com.formation.basefx.tp2.model.TVShow;
import com.formation.basefx.tp2.model.TVShowDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Form extends GridPane {

    private TextField tfTitle;
    private TextField tfSeasons;
    private TextField tfYear;
    private TextField tfCompany;
    private TextField tfScore;
    private TVShowDAO dao = new TVShowDAO();

    public Form(ShowsList shows, TableView<TVShow> table) {
        this.setVgap(9);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color:#458e88");
        this.setPadding(new Insets(10,5,10,5));

        // Titre du formulaire
        Label formTitle = new Label("Entrez les informations de la série");
        this.add(formTitle, 0,0,3,1);

        // Saisie du nombre de saisons
        Label lblTitle = new Label("Entrez le tire de la série : ");
        tfTitle = new TextField();
        this.add(lblTitle, 0,1,2,1);
        this.add(tfTitle, 2,1);

        // Saisie de la référence
        Label lblSeasons = new Label("Entrez le nombre de saisons de la série : ");
        tfSeasons = new TextField();
        this.add(lblSeasons, 0,2,2,1);
        this.add(tfSeasons, 2,2);

        // Saisie de l'année de sortie
        Label lblYear = new Label("Entrez l'année de sortie de la série : ");
        tfYear = new TextField();
        this.add(lblYear, 0,3,2,1);
        this.add(tfYear, 2,3);

        // Saisie de la maison de production
        Label lblCompany = new Label("Entrez la maison de production de la série : ");
        tfCompany = new TextField();
        this.add(lblCompany, 0,4,2,1);
        this.add(tfCompany, 2,4);

        // Saisie du score
        Label lblScore = new Label("Donnez une note sur 5 à la série : ");
        tfScore = new TextField();
        this.add(lblScore, 0,5,2,1);
        this.add(tfScore, 2,5);

        // Boutons enregistrer, mettre à jour et supprimer
        HBox hbActionBtns = new HBox(10);
        hbActionBtns.setAlignment(Pos.CENTER);
        Button addBtn = new Button("Ajouter");
        Button updateBtn = new Button("Mettre à jour");
        Button deleteBtn = new Button("Supprimer");

        hbActionBtns.getChildren().addAll(addBtn, deleteBtn, updateBtn);
        this.add(hbActionBtns, 0,7,3,1);

        // Action handlers des boutons
        addBtn.setOnAction(ae -> {
            TVShow myShow = getShowFromForm();
            shows.addShow(myShow);
            dao.persistShow(myShow);
            table.refresh();
        });

        updateBtn.setOnAction(ae -> {
            TVShow myShow = getShowFromForm();
            shows.updateShow(myShow);
            dao.updateShow(myShow);
            table.refresh();
        });

        deleteBtn.setOnAction(ae -> {
            TVShow myShow = getShowFromForm();
            shows.deleteShow(myShow);
            dao.updateShow(myShow);
            table.refresh();
        });
    }

    private TVShow getShowFromForm() {
        TVShow myShow = new TVShow(tfTitle.getText(),
                Integer.parseInt(tfSeasons.getText()),
                Integer.parseInt(tfYear.getText()),
                tfCompany.getText(),
                Integer.parseInt(tfScore.getText()));
        return myShow;
    }

    public TextField getTfTitle() {
        return tfTitle;
    }

    public TextField getTfSeasons() {
        return tfSeasons;
    }

    public TextField getTfYear() {
        return tfYear;
    }

    public TextField getTfCompany() {
        return tfCompany;
    }

    public TextField getTfScore() {
        return tfScore;
    }
}
