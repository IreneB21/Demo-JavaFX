package com.formation.basefx.tp2.model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TVShowDAO {

    private List<TVShow> allShows = new ArrayList<>();
    private String filename = "Shows.csv";

    public void persistShow(TVShow show) {
        allShows.add(show);

        try (FileWriter fw = new FileWriter(filename)) {
            for (TVShow tvShow : allShows) {
                fw.append(tvShow.getTitle());
                fw.append("-");
                fw.append(tvShow.getNumberSeasons().toString());
                fw.append("-");
                fw.append(tvShow.getYear().toString());
                fw.append("-");
                fw.append(tvShow.getCompany());
                fw.append("-");
                fw.append(tvShow.getScore().toString());
                fw.append("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateShow(TVShow showToUpdate) {
        for (TVShow show : allShows) {
            if (show.getTitle().equalsIgnoreCase(showToUpdate.getTitle())) {
                allShows.remove(show);
                persistShow(showToUpdate);
            }
        }
    }

    public void deleteShow(TVShow show) {

    }
}
