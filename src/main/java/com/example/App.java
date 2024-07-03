package com.example;

public class App {
    private static final String HARDCODED_USERNAME = "admin";
    private static final String HARDCODED_PASSWORD = "password123";  // Hardcoded password

    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        boolean isAuthenticated = authService.authenticate(HARDCODED_USERNAME, HARDCODED_PASSWORD);

        if (isAuthenticated) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
