package com.formation.basefx.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.JOptionPane;

public class Action implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Hello World !");
    }
}
