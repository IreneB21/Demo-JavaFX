package com.formation.basefx.exercices.exo3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

// En étendant la classe HBox, la classe TopPanel hérite de ses propriétés
public class TopPanel extends HBox {

    // La classe TopPanel possède comme attribut privé des boutons
    private Button btn1 = new Button("Rouge");
    private Button btn2 = new Button("Bleu");
    private Button btn3 = new Button("Vert");
    private Button btn4 = new Button("Orange");

    /*
    Dans le constructeur du TopPanel, on ajoute les boutons à la liste des
    Nodes enfants de la HBox et on stylise les éléments
     */
    public TopPanel() {
        getChildren().addAll(btn1, btn2, btn3, btn4);
        setSpacing(50);
        setAlignment(Pos.CENTER);
    }
}
