package com.formation.basefx.tp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ArticlesList {

    private ObservableList<Article> articles;

    public ArticlesList() {
        this.articles = FXCollections.observableArrayList();

        this.addArticle(new Book("La maison des feuilles", "ref1", 34.99, 800));
        this.addArticle(new Book("L'assassin royal - Partie 1", "ref2", 9.99, 800));
        this.addArticle(new Book("La horde du contrevent", "ref3", 23.99, 800));
        this.addArticle(new BlueRay("Interstellar", "ref4", 24.99, 125));
        this.addArticle(new BlueRay("Gravity", "ref5", 24.99, 125));
        this.addArticle(new BlueRay("Dune - Collector edition", "ref6", 60.00, 125));
        this.addArticle(new Vinyle("Carmen Collector edition", "ref7", 259.50, 200));
        this.addArticle(new Vinyle("The Legend - Bob Marley", "ref8", 60.49, 200));
        this.addArticle(new Vinyle("Lost Themes - John Carpenter", "ref9", 71.50, 200));
    }

    public boolean addArticle(Article article) {
        if (findByRef(article.getRef()) == null) {
            return this.articles.add(article);
        }
        return false;
    }

    public boolean removeArticle(Article article) {
        return this.articles.remove(article);
    }

    public boolean updateArticle(Article article) {
        Article articleInList;
        if ((articleInList = findByRef(article.getRef())) != null) {
            articleInList.setName(article.getName());
            articleInList.setPrice(article.getPrice());
            articleInList.setWeight(article.getWeight());
            return true;
        }
        return false;
    }

    public Article findByRef(String ref) {
        for (Article article : articles) {
            if (article.getRef().equalsIgnoreCase(ref)) {
                return article;
            }
        }
        return null;
    }

    public ObservableList<Article> getArticles() {
        return articles;
    }
}
