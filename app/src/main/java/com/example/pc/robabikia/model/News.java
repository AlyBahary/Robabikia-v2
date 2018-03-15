package com.example.pc.robabikia.model;

/**
 * Created by Pc on 2/21/2018.
 */

public class News {
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;


    public News(String title, String description) {

        this.title = title;
        this.description = description;
    }
}
