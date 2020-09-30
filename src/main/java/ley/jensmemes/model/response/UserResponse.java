package ley.jensmemes.model.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.Expose;
import ley.jensmemes.model.User;

import java.io.InputStream;
import java.io.InputStreamReader;

public class UserResponse extends Response {

    public static UserResponse read(InputStream json) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            return gson.fromJson(new InputStreamReader(json), UserResponse.class);
        } catch (JsonSyntaxException e) {
            UserResponse res = new UserResponse();
            res.status = 400;
            return res;
        }
    }

    @Expose
    public User user;

    public User toUser() {
        return user;
    }

}
