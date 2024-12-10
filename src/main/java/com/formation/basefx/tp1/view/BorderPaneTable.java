package com.formation.basefx.tp1.view;

import com.formation.basefx.tp1.model.Article;
import com.formation.basefx.tp1.model.ArticlesList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class BorderPaneTable extends BorderPane {

    public BorderPaneTable(ArticlesList articles, TableView<Article> table) {
        super();

        table.setEditable(false);

        // Création de la colonne
        TableColumn<Article, String> nameCol = new TableColumn<>("Nom");
        nameCol.setMinWidth(250);
        // Spécifier comment remplir la donnée pour chaque cellule de cette colonne en spécifiant un "cell value factory" pour cette colonne
        nameCol.setCellValueFactory(new PropertyValueFactory<Article, String>("name"));

        TableColumn<Article, String> refCol = new TableColumn<>("Référence");
        refCol.setMinWidth(150);
        refCol.setCellValueFactory(new PropertyValueFactory<Article, String>("ref"));

        TableColumn<Article, String> priceCol = new TableColumn<>("Prix");
        priceCol.setMinWidth(150);
        priceCol.setCellValueFactory(new PropertyValueFactory<Article, String>("price"));

        TableColumn<Article, String> weightCol = new TableColumn<>("poids");
        weightCol.setMinWidth(150);
        weightCol.setCellValueFactory(new PropertyValueFactory<Article, String>("weight"));

        TableColumn<Article, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(150);
        typeCol.setCellValueFactory(new PropertyValueFactory<Article, String>("type"));

        TableColumn<Article, String> fragilityCol = new TableColumn<>("Fragilité");
        fragilityCol.setMinWidth(150);
        fragilityCol.setCellValueFactory(new PropertyValueFactory<Article, String>("fragility"));

        table.getColumns().addAll(nameCol, refCol, priceCol, weightCol, typeCol, fragilityCol);

        // On remplit la table avec la liste observable
        table.setItems(articles.getArticles());

        this.setCenter(table);
    }

    BorderPane root = new BorderPane();
}
