package com.example.levon.exampletwo;

import java.util.ArrayList;

/**
 * Created by HP on 7/5/2018.
 */

public class CommentModel {
    private String name;
    private String text;

    public CommentModel(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

}
