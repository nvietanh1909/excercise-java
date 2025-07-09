package com.example.page.auth;

import com.example.api.AuthAPI;
import com.example.config.TokenConfig;
import com.example.page.book.BookAddPage;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage {
    private final AuthAPI authAPI = new AuthAPI();

    public void show(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Đăng nhập");
        Label messageLabel = new Label();

        grid.add(emailLabel, 0, 0);
        grid.add(emailField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(messageLabel, 1, 3);

        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            TokenConfig response = authAPI.login(email, password);
            if (response != null && response.getToken() != null) {
                new BookAddPage(response.getToken()).show(stage);
            } else {
                messageLabel.setText("Đăng nhập thất bại!");
            }
        });

        Scene scene = new Scene(grid, 400, 250);
        stage.setScene(scene);
        stage.setTitle("Đăng nhập");
        stage.show();
    }
} 