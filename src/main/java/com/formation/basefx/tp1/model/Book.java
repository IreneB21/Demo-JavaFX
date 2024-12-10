package com.formation.basefx.tp1.model;

public class Book extends Article {

    public Book(String name, String ref, double price, int weight) {
        super(name, ref, price, weight);
        this.setType();
        this.setFragility();
    }

    public void setType() {
        this.type = "Livre";
    }

    public void setFragility() {
        this.fragility = "aucune";
    }
}
