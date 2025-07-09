package com.example.api;

import com.example.config.UrlConfig;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.model.*;

public class BookAPI {
    private static final String BASE_URL = UrlConfig.BASE_URL;
    private final HttpClient httpClient;
    private final Gson gson;
    private final String token;

    public BookAPI(String token) {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        this.token = token;
    }


    public boolean addBook(BookModel book, Path imagePath) throws Exception {
        String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
        StringBuilder sb = new StringBuilder();
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"title\"\r\n\r\n" + book.getTitle() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"authors\"\r\n\r\n" + String.join(",", book.getAuthors()) + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"description\"\r\n\r\n" + book.getDescription() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"category\"\r\n\r\n" + book.getCategory() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"quantity\"\r\n\r\n" + book.getQuantity() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"publisher\"\r\n\r\n" + book.getPublisher() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"price\"\r\n\r\n" + book.getPrice() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"publishedDate\"\r\n\r\n" + book.getPublishedDate() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"language\"\r\n\r\n" + book.getLanguage() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"isbn\"\r\n\r\n" + book.getIsbn() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"page\"\r\n\r\n" + book.getPage() + "\r\n");
        sb.append("--" + boundary + "\r\n");
        sb.append("Content-Disposition: form-data; name=\"image\"; filename=\"image.jpg\"\r\n");
        sb.append("Content-Type: image/jpeg\r\n\r\n");
        byte[] fileBytes = java.nio.file.Files.readAllBytes(imagePath);
        byte[] formBytes = sb.toString().getBytes();
        byte[] endBytes = ("\r\n--" + boundary + "--\r\n").getBytes();
        byte[] requestBody = new byte[formBytes.length + fileBytes.length + endBytes.length];
        System.arraycopy(formBytes, 0, requestBody, 0, formBytes.length);
        System.arraycopy(fileBytes, 0, requestBody, formBytes.length, fileBytes.length);
        System.arraycopy(endBytes, 0, requestBody, formBytes.length + fileBytes.length, endBytes.length);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/books"))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(BodyPublishers.ofByteArray(requestBody))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 201 || response.statusCode() == 200;
    }
} 