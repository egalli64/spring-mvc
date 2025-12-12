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
    Optional<Contact> findById(Long id);
    List<Contact> findAll();
    void deleteById(Long id);
    void deleteAll();
}
