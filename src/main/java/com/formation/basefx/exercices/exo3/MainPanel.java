package com.formation.basefx.exercices.exo3;

import javafx.scene.layout.BorderPane;

public class MainPanel extends BorderPane {
    // Le MainPanel possède en attribut nos deux autres panneaux
    private TopPanel topPanel = new TopPanel();
    private BottomPanel bottomPanel = new BottomPanel();

    // On positionne les deux autres panneaux dans le constructeur
    public MainPanel() {
        setTop(topPanel);
        setBottom(bottomPanel);
    }
}
