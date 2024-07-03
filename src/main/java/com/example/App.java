package com.example;

public class App {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        boolean isAuthenticated = authService.authenticate("admin", "password123");

        if (isAuthenticated) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
