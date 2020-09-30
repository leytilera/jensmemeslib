package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import ley.jensmemes.model.User;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class UsersResponse extends Response {

    public static UsersResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), UsersResponse.class);
        } catch (JsonSyntaxException e) {
            UsersResponse res = new UsersResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public List<User> users;

}
