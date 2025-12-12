/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s3;

import java.time.LocalDate;

/**
 * Coder DTO
 */
public record Coder(Long id, String firstName, String lastName, LocalDate hired) {
    public Coder(Long id, String firstName, String lastName) {
        this(id, firstName, lastName, LocalDate.now());
    }
}
