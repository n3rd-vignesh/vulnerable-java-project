package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HardcodedCredentialsExample {
    public void run() {
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUsername = "root";

        try {
            // Directly using hardcoded password in the connection statement
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, "hardcodedpassword");
            System.out.println("Connection successful!");

            // Perform database operations here...

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

