package ley.jensmemes;

import ley.jensmemes.model.response.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HTTPClient {

    static URIBuilder getBuilder(String path) {
        try {
            return new URIBuilder("https://data.tilera.xyz").setPathSegments("api", "jensmemes", path);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static UploadResponse upload(String token, String category, File image) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("upload");
        HttpPost request = new HttpPost(builder.build());
        MultipartEntityBuilder mpbuild = MultipartEntityBuilder.create();
        mpbuild.addTextBody("category", category);
        mpbuild.addTextBody("token", token);
        mpbuild.addBinaryBody("file", image);
        request.setEntity(mpbuild.build());
        HttpEntity response = client.execute(request).getEntity();
        return UploadResponse.read(response.getContent());
    }

    public static CategoriesResponse categories() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("categories");
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return CategoriesResponse.read(response.getContent());
    }

    public static UsersResponse users() throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("users");
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return UsersResponse.read(response.getContent());
    }

    public static CategoryResponse category(String id) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("category");
        builder.addParameter("id", id);
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return CategoryResponse.read(response.getContent());
    }

    public static MemeResponse meme(int id) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("meme");
        builder.setParameter("id", String.valueOf(id));
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return MemeResponse.read(response.getContent());
    }

    public static MemesResponse memes(String category, String user, String search) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("memes");
        if (category != null) {
            builder.setParameter("category", category);
        }
        if (user != null) {
            builder.setParameter("user", user);
        }
        if (search != null) {
            builder.setParameter("search", search);
        }
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return MemesResponse.read(response.getContent());
    }

    public static UserResponse user(String id) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("user");
        builder.setParameter("id", id);
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return UserResponse.read(response.getContent());
    }

    public static UserResponse userByName(String name) throws IOException, URISyntaxException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder builder = getBuilder("user");
        builder.setParameter("name", name);
        HttpGet request = new HttpGet(builder.build());
        HttpEntity response = client.execute(request).getEntity();
        return UserResponse.read(response.getContent());
    }

}
