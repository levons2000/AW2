package com.example.levon.zakuskiproject;

public class Items{
    private String name;
    private String country;
    private String imgUrl;
    private String wikiUrl;
    private Calorie calorie;

    public Items(String name, String country, String imgUrl, String wikiUrl , Calorie calorie) {
        this.name = name;
        this.country = country;
        this.imgUrl = imgUrl;
        this.wikiUrl = wikiUrl;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }


    public String getCountry() {
        return country;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }
    public Calorie getCalorie() {
        return calorie;
    }

}
