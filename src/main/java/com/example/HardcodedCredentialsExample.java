package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HardcodedCredentialsExample {
    public void run() {
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUsername = "root";
        String dbPassword = System.getenv("DB_PASSWORD"); // Retrieve the password from the environment variable

        if (dbPassword == null) {
            throw new IllegalStateException("Database password environment variable not set");
        }

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connection successful!");

            // Perform database operations here...

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
