package com.formation.basefx.tp.model;

public class Vinyle extends Article {

    public Vinyle(String name, String ref, double price, int weight) {
        super(name, ref, price, weight);
        this.setType();
        this.setFragility();
    }

    public void setType() {
        this.type = "Vinyle";
    }

    public void setFragility() {
        this.fragility = "importante";
    }
}
