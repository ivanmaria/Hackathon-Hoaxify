package com.github.ivanmaria.hoaxify;

/**
 * Created by IsaacIvan on 10-03-2018.
 */
public class CommentData {
    int id;
    String name;
    String designation;
    String message;
    String feeling;

    public CommentData(String name, String designation, String message, String feeling, int id ) {
        this.name=name;
        this.designation=designation;
        this.message=message;
        this.feeling=feeling;
        this.id=id;
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

    public int getId() {
        return id;
    }

}