package com.example;

public class HardcodedCredentialsExample {
    private static final String HARDCODED_USERNAME = "admin";
    private static final String HARDCODED_PASSWORD = "password123";

    public void run() {
        if (authenticate(HARDCODED_USERNAME, HARDCODED_PASSWORD)) {
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed due to misconfiguration.");
        }
    }

    private boolean authenticate(String username, String password) {
        return "admin".equals(username) && "password123".equals(password);
    }
}
