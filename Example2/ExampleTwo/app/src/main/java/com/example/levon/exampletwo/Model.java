package com.example.levon.exampletwo;

import android.widget.ListView;

import java.util.ArrayList;

public class Model {
    private String imgUrl;
    int likeCounter = 0;
    int commentCounter = 0;
    boolean isLiked = false;
    boolean isCommentActive = false;
    ArrayList<CommentModel> arrayList = new ArrayList<>();

    public Model(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void plusLike() {
        ++likeCounter;
    }

    public void plusComment() {
        ++commentCounter;
    }

    public void minusComment() {
        --commentCounter;
    }

    public void minusLike(){
        --likeCounter;
    }




}
