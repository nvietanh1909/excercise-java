package com.example;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnnection {
    public static Connection getConnection() {
        Properties props = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Cannot find db.properties");
                return null;
            }
            props.load(input);
            String host = props.getProperty("db.host");
            String port = props.getProperty("db.port");
            String db = props.getProperty("db.name");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.pass");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
            return DriverManager.getConnection(url, user, pass);
        } catch (IOException | SQLException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            return null;
        }
    }

}
