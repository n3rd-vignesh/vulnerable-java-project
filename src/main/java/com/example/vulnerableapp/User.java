package com.example.vulnerableapp;

public class User {
    private String name;
    private int age;

    // Default constructor is necessary for Jackson to deserialize JSON
    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
