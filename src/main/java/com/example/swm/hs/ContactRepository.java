/*
 * Spring Boot Web MVC tutorial - Hypermedia System
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hs;

import java.util.List;
import java.util.Optional;

/**
 * A simple repository interface
 */
public interface ContactRepository {
    Contact save(Contact contact);
    Optional<Contact> findByName(String name);
    List<Contact> findAll();
    List<Contact> findContaining(String sub);
    void deleteByName(String name);
    void deleteAll();
}
