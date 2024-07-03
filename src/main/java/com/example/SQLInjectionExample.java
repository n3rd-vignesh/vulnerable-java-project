package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLInjectionExample {
    public void run() {
        String username = "admin' OR '1'='1";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("User authenticated successfully!");
            } else {
                System.out.println("Authentication failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
