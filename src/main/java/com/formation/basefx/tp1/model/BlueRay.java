package com.formation.basefx.tp1.model;

public class BlueRay extends Article {
    
    public BlueRay(String name, String ref, double price, int weight) {
        super(name, ref, price, weight);
        this.setType();
        this.setFragility();
    }

    public void setType() {
        this.type = "BlueRay";
    }

    public void setFragility() {
        this.fragility = "légère";
    }
}
