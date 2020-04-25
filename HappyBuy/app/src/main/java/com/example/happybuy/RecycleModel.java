package com.example.happybuy;

public class RecycleModel {

    private String title;
    private int image;


    public RecycleModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public RecycleModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
