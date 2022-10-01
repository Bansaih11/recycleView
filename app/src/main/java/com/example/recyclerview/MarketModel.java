package com.example.recyclerview;

public class MarketModel {
    String Title;
    String description;
    int image;

    public MarketModel(String title, String description, int image) {
        Title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
