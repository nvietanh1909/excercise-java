package com.example.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.config.TokenConfig;
import com.example.config.UrlConfig;
import com.google.gson.Gson;

public class AuthAPI {
    private static final String BASE_URL = UrlConfig.BASE_URL;
    private final HttpClient httpClient;
    private final Gson gson;

    public AuthAPI() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public TokenConfig login(String email, String password) {
        try {
            String jsonBody = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/users/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return gson.fromJson(response.body(), TokenConfig.class);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
