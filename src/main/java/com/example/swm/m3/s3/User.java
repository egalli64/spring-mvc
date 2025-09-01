/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple DTO to be used in a Thymeleaf Standard Expression
 */
public record User(String firstName, String lastName, int age) {
    public int pendingMessages() {
        // assume some real logic here
        return ThreadLocalRandom.current().nextInt(100);
    }
}
