package com.github.ivanmaria.hoaxify;

/**
 * Created by IsaacIvan on 10-03-2018.
 */

public class HoaxList {

    int id;
    String text;

    public HoaxList(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}