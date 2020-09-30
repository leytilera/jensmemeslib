package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import ley.jensmemes.model.Category;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CategoriesResponse extends Response {

    public static CategoriesResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), CategoriesResponse.class);
        } catch (JsonSyntaxException e) {
            CategoriesResponse res = new CategoriesResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public List<Category> categories;

}
