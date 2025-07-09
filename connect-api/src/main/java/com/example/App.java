package com.example;


import com.example.page.auth.LoginPage;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        new LoginPage().show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
