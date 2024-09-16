package com.example.vulnerableapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        // Vulnerable code using jackson-databind
        String jsonString = "{\"name\":\"John Doe\",\"age\":30}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserialize JSON string to User object
            User user = objectMapper.readValue(jsonString, User.class);
            System.out.println("User Name: " + user.getName());
            System.out.println("User Age: " + user.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
