/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s2;

import java.time.LocalDate;

/**
 * Coder DTO
 */
public record Coder(Integer id, String firstName, String lastName, LocalDate hired, Integer salary) {
    public Coder(Integer id, String firstName, String lastName, Integer salary) {
        this(id, firstName, lastName, LocalDate.now(), salary);
    }
}
