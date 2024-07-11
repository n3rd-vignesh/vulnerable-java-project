package com.example;

import java.util.HashMap;
import java.util.Map;

public class MissingAuthenticationExample {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Adding some dummy users
        users.put("user1", "User One");
        users.put("user2", "User Two");
        users.put("user3", "User Three");

        // Simulating a request to delete a user without authentication
        String userIdToDelete = "user2";
        deleteUser(userIdToDelete);

        // Display remaining users
        System.out.println("Remaining users: " + users);
    }

    // Critical function with missing authentication
    public static void deleteUser(String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            System.out.println("User " + userId + " has been deleted.");
        } else {
            System.out.println("User " + userId + " not found.");
        }
    }
}
