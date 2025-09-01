/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s4;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple DTO for experimenting with Thymeleaf
 */
public record User(String name, boolean active, boolean admin) {
    public boolean idle() {
        // assume some real logic here
        return ThreadLocalRandom.current().nextBoolean();
    }
}
