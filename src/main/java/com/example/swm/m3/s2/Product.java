/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s2;

/**
 * A simple DTO to be used in a Thymeleaf Variable Expression
 */
public record Product(String name, int price) {
    public String info() {
        return "Some interesting information about the product " + name;
    }
}
