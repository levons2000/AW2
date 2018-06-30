package com.example.levon.zakuskiproject;

public class Items{
    private String name;
    private String country;
    private String imgUrl;
    private String wikiUrl;

    public Items(String name, String country, String imgUrl, String wikiUrl) {
        this.name = name;
        this.country = country;
        this.imgUrl = imgUrl;
        this.wikiUrl = wikiUrl;
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

}
