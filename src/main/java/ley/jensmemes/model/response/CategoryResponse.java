package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import ley.jensmemes.model.Category;

import java.io.InputStream;
import java.io.InputStreamReader;

public class CategoryResponse extends Response {

    public static CategoryResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), CategoryResponse.class);
        } catch (JsonSyntaxException e) {
            CategoryResponse res = new CategoryResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public Category category;

    public Category toCategory() {
        return category;
    }

}
