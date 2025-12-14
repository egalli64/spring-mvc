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
    Optional<Contact> find(Long id);
    List<Contact> findAll();
    List<Contact> findContaining(String sub);
    void delete(Long id);
    void deleteAll();
}
