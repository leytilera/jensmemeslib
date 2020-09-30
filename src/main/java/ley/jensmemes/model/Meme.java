package ley.jensmemes.model;

import com.google.gson.annotations.Expose;

public class Meme {

    @Expose
    public int id;

    @Expose
    public String link;

    @Expose
    public String category;

    @Expose
    public String user;

}
