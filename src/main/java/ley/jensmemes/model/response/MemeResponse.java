package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import ley.jensmemes.model.Meme;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MemeResponse  extends Response {

    public static MemeResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), MemeResponse.class);
        } catch (JsonSyntaxException e) {
            MemeResponse res = new MemeResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public int id;

    @Expose
    public String link;

    @Expose
    public String category;

    @Expose
    public String user;

    public Meme toMeme() {
        Meme meme = new Meme();
        meme.id = id;
        meme.link = link;
        meme.category = category;
        meme.user = user;
        return meme;
    }

}
