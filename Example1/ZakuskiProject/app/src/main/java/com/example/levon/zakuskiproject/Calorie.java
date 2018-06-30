package com.example.levon.zakuskiproject;

public enum Calorie {
    LOW_CARB(1),
    MEDIUM_CARB(2),
    BALANCED(3),
    LOW_FAT(4),
    MEDIUM_FAT(5);

    private int i;

    Calorie(int i) {
        if (i <= 5 && i >= 1) {
            this.i = i;
        }
    }

    public int getI() {
        return i;
    }
}
