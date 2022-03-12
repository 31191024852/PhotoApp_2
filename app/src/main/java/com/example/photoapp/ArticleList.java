package com.example.photoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArticleList {
    @SerializedName("articles")
    @Expose
    private ArrayList<Article> articles = new ArrayList<Article>();

    public ArticleList(ArrayList<Article> articles) {
        this.setArticles(articles);
    }

    public ArticleList(){}

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public void addArticles(Article article){
        this.articles.add(article);
    }
}
