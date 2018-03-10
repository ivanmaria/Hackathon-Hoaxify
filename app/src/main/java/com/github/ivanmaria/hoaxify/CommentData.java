package com.github.ivanmaria.hoaxify;

/**
 * Created by IsaacIvan on 10-03-2018.
 */
public class CommentData {

    String name;
    String designation;
    String message;
    String feeling;

    public CommentData(String name, String designation, String message, String feeling ) {
        this.name=name;
        this.designation=designation;
        this.message=message;
        this.feeling=feeling;

    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getMessage() {
        return message;
    }

    public String getFeeling() {
        return feeling;
    }

}