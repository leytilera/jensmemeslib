package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import ley.jensmemes.model.Meme;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MemesResponse extends Response {

    public static MemesResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), MemesResponse.class);
        } catch (JsonSyntaxException e) {
            MemesResponse res = new MemesResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public List<Meme> memes;

}
