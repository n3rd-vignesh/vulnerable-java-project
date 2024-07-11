package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionExample {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter database URL: ");
        String dbUrl = scanner.nextLine();

        System.out.print("Enter database username: ");
        String dbUsername = scanner.nextLine();

        System.out.print("Enter database password: ");
        String dbPassword = scanner.nextLine();

        System.out.print("Enter username to search: ");
        String usernameToSearch = scanner.nextLine();

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement();


            String query = "SELECT * FROM users WHERE username = '" + usernameToSearch + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

