/*
 * Spring Boot Web MVC tutorial - Hypermedia System
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A very simple Spring Service
 */
@Service
public class ContactService {
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public Optional<Contact> getContact(Long id) {
        log.trace("Enter getContact({})", id);

        return repo.find(id);
    }

    public List<Contact> getContacts() {
        log.trace("Enter getContacts()");

        return repo.findAll();
    }

    public List<Contact> search(String sub) {
        log.trace("Enter search({})", sub);

        return repo.findContaining(sub);
    }
}
