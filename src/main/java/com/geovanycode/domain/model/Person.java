package com.geovanycode.domain.model;

public class Person {
    private Long id;
    private String name;
    private String email;

    public Person(String name, String email) {
        validateName(name);
        validateEmail(email);
        this.name = name;
        this.email = email;
    }

    public Person(Long id, String name, String email) {
        this(name, email);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void changeName(String newName) {
        validateName(newName);
        this.name = newName;
    }

    public void changeEmail(String newEmail) {
        validateEmail(newEmail);
        this.email = newEmail;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
}