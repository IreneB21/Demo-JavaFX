package com.formation.basefx.event.transition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SecondPan extends HBox {

    private Button btn = new Button("Revenir en arrière");

    /*
     Dans le constructeur, on stylise le panneau et on lui ajoute le label en
     tant que Node enfant
     */
    public SecondPan() {
        super();
        setPrefSize(400, 200);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color:pink");
        getChildren().add(btn);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                FirstPan firstPan = new FirstPan();
                Scene scene = new Scene(firstPan);
                Stage stage = (Stage) getScene().getWindow();
                stage.setScene(scene);
            }
        });
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
