package com.example;

public class AuthenticationService {
    private Database database = new Database();

    public boolean authenticate(String username, String password) {
        return database.validateUser(username, password);
    }
}
