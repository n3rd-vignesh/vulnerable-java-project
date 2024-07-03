package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSCommandInjectionExample {
    public void run() {
        String userInput = "ls; echo 'Hello World!'";

        try {
            Process process = Runtime.getRuntime().exec(userInput);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
