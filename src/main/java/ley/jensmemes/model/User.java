package ley.jensmemes.model;

import com.google.gson.annotations.Expose;

public class User {

    @Expose
    public String id;

    @Expose
    public String name;

    @Expose
    public String userdir;

    @Expose
    public String tokenhash;

    @Expose
    public int dayuploads;

}
