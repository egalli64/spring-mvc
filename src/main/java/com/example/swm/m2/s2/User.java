/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s2;

/**
 * A simple JavaBean
 */
public class User {
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + "]";
    }
}
