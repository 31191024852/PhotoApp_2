package com.example.photoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Article {
    private String article_description="";
    private String article_id ="";
    private String article_image="";
    private String article_title="";



    public Article(String id, String source_photo, String caption_photo, String description_photo) {
        this.article_id = id;
        this.article_image = source_photo;
        this.article_title = caption_photo;
        this.article_description = description_photo;
    }

    public  Article(){}


    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_image() {
        return article_image;
    }

    public void setArticle_image(String article_image) {
        this.article_image = article_image;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_description() {
        return article_description;
    }

    public void setArticle_description(String article_description) {
        this.article_description = article_description;
    }


}


