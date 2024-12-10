package com.formation.basefx.tp.view;

import com.formation.basefx.tp.model.Article;
import com.formation.basefx.tp.model.ArticlesList;
import com.formation.basefx.tp.model.BlueRay;
import com.formation.basefx.tp.model.Book;
import com.formation.basefx.tp.model.Vinyle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GridPaneForm extends GridPane {

    private TextField tfName;
    private TextField tfRef;
    private TextField tfPrice;
    private TextField tfWeight;

    private ToggleButton tbBook;
    private ToggleButton tbBlueRay;
    private ToggleButton tbVinyle;

    public GridPaneForm(ArticlesList myArticles, TableView<Article> table) {
        this.setVgap(5);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color:#f9caf8");
        this.setPadding(new Insets(10,10,10,10));

        // Titre du formulaire
        Label lblTitle = new Label("Entrez les informations de votre article");
        this.add(lblTitle, 0,0,3,1);

        // Saisie du nom
        Label lblName = new Label("Entrez le nom de l'article : ");
        tfName = new TextField();
        tfName.setText("Nom");
        this.add(lblName, 0,1,2,1);
        this.add(tfName, 2,1);

        // Saisie de la référence
        Label lblRef = new Label("Entrez la référence de l'article : ");
        tfRef = new TextField();
        tfRef.setText("Référence");
        this.add(lblRef, 0,2,2,1);
        this.add(tfRef, 2,2);

        // Saisie du prix
        Label lblPrice = new Label("Entrez le prix de l'article : ");
        tfPrice = new TextField();
        tfPrice.setText("Prix");
        this.add(lblPrice, 0,3,2,1);
        this.add(tfPrice, 2,3);

        // Saisie du poids
        Label lblWeight = new Label("Entrez le poids de l'article : ");
        tfWeight = new TextField();
        tfWeight.setText("Poids");
        this.add(lblWeight, 0,4,2,1);
        this.add(tfWeight, 2,4);

        // Saisie du type d'article
        tbBook = new ToggleButton("Livre");
        tbBlueRay = new ToggleButton("BlueRay");
        tbVinyle = new ToggleButton("Vinyle");
        ToggleGroup tgType = new ToggleGroup();
        tgType.getToggles().addAll(tbBook, tbBlueRay, tbVinyle);

        HBox hbToggleButtons = new HBox();
        hbToggleButtons.getChildren().addAll(tbBook, tbBlueRay, tbVinyle);

        Label lbtType = new Label("Type de l'article : ");
        this.add(lbtType, 0,5);
        this.add(hbToggleButtons, 2,5,2,1);

        // Boutons valider, supprimer et mettre à jour
        HBox hbActionBtns = new HBox();
        Button addBtn = new Button("Ajouter");
        Button deleteBtn = new Button("Supprimer");
        Button updateBtn = new Button("Mettre à jour");

        hbActionBtns.getChildren().addAll(addBtn, deleteBtn, updateBtn);
        this.add(hbActionBtns, 0,7,3,1);

        // Action handlers des boutons
        addBtn.setOnAction(ae -> {
            Article myArticle = getArticleFromForm();
            myArticles.addArticle(myArticle);
            System.out.println(myArticle);
            table.refresh();
        });

        deleteBtn.setOnAction(ae -> {
            Article article = myArticles.findByRef(tfRef.getText());
            myArticles.removeArticle(article);
            table.refresh();
        });

        updateBtn.setOnAction(ae -> {
            Article myArticle = getArticleFromForm();
            myArticles.updateArticle(myArticle);
            System.out.println(myArticle);
            table.refresh();
        });
    }

    private Article getArticleFromForm() {
        Article myArticle;

        if (tbBook.isSelected()) {
            myArticle = new Book(
                    tfName.getText(),
                    tfRef.getText(),
                    Double.parseDouble(tfPrice.getText()),
                    Integer.parseInt(tfWeight.getText())
            );
        } else if (tbBlueRay.isSelected()) {
            myArticle = new BlueRay(
                    tfName.getText(),
                    tfRef.getText(),
                    Double.parseDouble(tfPrice.getText()),
                    Integer.parseInt(tfWeight.getText())
            );
        } else {
            myArticle = new Vinyle(
                    tfName.getText(),
                    tfRef.getText(),
                    Double.parseDouble(tfPrice.getText()),
                    Integer.parseInt(tfWeight.getText())
            );
        }
        return myArticle;
    }

    public TextField getTfName() {
        return tfName;
    }

    public TextField getTfRef() {
        return tfRef;
    }

    public TextField getTfPrice() {
        return tfPrice;
    }

    public TextField getTfWeight() {
        return tfWeight;
    }

    public ToggleButton getTbBook() {
        return tbBook;
    }

    public ToggleButton getTbBlueRay() {
        return tbBlueRay;
    }

    public ToggleButton getTbVinyle() {
        return tbVinyle;
    }
}
