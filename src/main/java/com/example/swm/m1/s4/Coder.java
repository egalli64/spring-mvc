/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s4;

import java.time.LocalDate;

/**
 * Coder DTO
 */
public record Coder(Integer id, String firstName, String lastName, LocalDate hired) {
    public Coder(Integer id, String firstName, String lastName) {
        this(id, firstName, lastName, LocalDate.now());
    }
}
