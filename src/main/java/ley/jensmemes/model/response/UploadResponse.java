package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class UploadResponse extends Response {

    public static UploadResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), UploadResponse.class);
        } catch (JsonSyntaxException e) {
            UploadResponse res = new UploadResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public List<String> files;

}
