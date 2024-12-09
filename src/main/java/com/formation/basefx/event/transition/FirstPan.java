package com.formation.basefx.event.transition;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstPan extends HBox {

    private Button btn = new Button("Changer de scène");

    /*
     Dans le constructeur, on stylise le panneau, on lui ajoute le bouton en tant que Node enfant
     et on déclenche un événement lorsque le bouton est cliqué
     */
    public FirstPan() {
        super();
        getChildren().add(btn);
        setPrefSize(400, 200);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color:teal");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                // On instancie notre second panneau
                SecondPan secondPan = new SecondPan();
                // On instancie une nouvelle scène en lui donnant notre nouveau panneau
                Scene scene = new Scene(secondPan);
                // On récupère notre Stage en remontant l'arborescence de composant à partir du panneau courant
                Stage stage = (Stage) getScene().getWindow();
                // On donne à notre Stage la nouvelle scène
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
