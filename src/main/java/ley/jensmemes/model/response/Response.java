package ley.jensmemes.model.response;

import com.google.gson.annotations.Expose;

import java.io.InputStream;

public class Response {

    @Expose
    public int status;

    @Expose
    public String error;

}
