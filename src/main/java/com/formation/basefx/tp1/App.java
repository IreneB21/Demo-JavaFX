package com.formation.basefx.tp1;

import com.formation.basefx.tp1.model.Article;
import com.formation.basefx.tp1.model.ArticlesList;
import com.formation.basefx.tp1.view.BorderPaneTable;
import com.formation.basefx.tp1.view.GridPaneForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private ArticlesList myArticles = new ArticlesList();

    @Override
    public void start(Stage stage) throws Exception {
        TableView<Article> table = new TableView<Article>();
        VBox vbMain = new VBox();
        GridPaneForm form = new GridPaneForm(myArticles, table);
        BorderPaneTable bpTable = new BorderPaneTable(myArticles, table);
        vbMain.getChildren().addAll(form, bpTable);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            form.getTfName().setText(newSelection.getName());
            form.getTfRef().setText(newSelection.getRef());
            form.getTfPrice().setText(newSelection.getPrice().toString());
            form.getTfWeight().setText(newSelection.getWeight().toString());

            switch (newSelection.getType()) {
                case "BlueRay":
                    form.getTbBlueRay().setSelected(true);
                    form.getTbBook().setSelected(false);
                    form.getTbVinyle().setSelected(false);
                    break;
                case "Livre":
                    form.getTbBlueRay().setSelected(false);
                    form.getTbBook().setSelected(true);
                    form.getTbVinyle().setSelected(false);
                    break;
                case "Vinyle":
                    form.getTbBlueRay().setSelected(false);
                    form.getTbBook().setSelected(false);
                    form.getTbVinyle().setSelected(true);
                    break;
            }
        });

        Scene scene = new Scene(vbMain, 1000, 768);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
