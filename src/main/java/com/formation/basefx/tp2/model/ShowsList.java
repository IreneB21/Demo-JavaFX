package com.formation.basefx.tp2.model;

import com.formation.basefx.tp1.model.Article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShowsList {

    private ObservableList<TVShow> shows;

    public ShowsList() {
        this.shows = FXCollections.observableArrayList();
    }

    public void addShow(TVShow show) {
//        if (findByRef(article.getRef()) == null) {
//            return this.articles.add(article);
//        }
//        return false;
        this.shows.add(show);
    }

    public void updateShow(TVShow show) {
        for (TVShow tvShow : shows) {
            if (show.getTitle().equalsIgnoreCase(tvShow.getTitle())) {
                tvShow.setTitle(show.getTitle());
                tvShow.setNumberSeasons(show.getNumberSeasons());
                tvShow.setYear(show.getYear());
                tvShow.setCompany(show.getCompany());
                tvShow.setScore(show.getScore());
            }
        }
    }

    public void deleteShow(TVShow show) {
        this.shows.remove(show);
    }

    public ObservableList<TVShow> getShows() {
        return shows;
    }
}
