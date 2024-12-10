package com.formation.basefx.tp2.model;

public class TVShow {

    private String title;
    private Integer numberSeasons;
    private Integer year;
    private String company;
    private Integer score;

    public TVShow(String title, Integer numberSeasons, Integer year, String company, Integer score) {
        this.title = title;
        this.numberSeasons = numberSeasons;
        this.year = year;
        this.company = company;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberSeasons() {
        return numberSeasons;
    }

    public void setNumberSeasons(Integer numberSeasons) {
        this.numberSeasons = numberSeasons;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}