package com.formation.basefx.tp.model;

public abstract class Article {
    private String name;
    private String ref;
    private Double price;
    private Integer weight;
    protected String type;
    protected String fragility;

    public Article(String name, String ref, Double price, Integer weight) {
        this.name = name;
        this.ref = ref;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return this.type;
    }

    public abstract void setType();

    public String getFragility() { return this.fragility; }

    public abstract void setFragility();
}
