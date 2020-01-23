package com.example.mvvmrecyclerview.models;

public class NicePlace {
    private String title;
    private String imageUrl;
    public NicePlace()
    {

    }
   public NicePlace(String imageUrl,String title)
    {
        this.title=title;
        this.imageUrl=imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
