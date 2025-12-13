/*
 * Spring Boot Web MVC tutorial - Hypermedia System
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A simple mockingly concrete repository
 */
@Repository
public class InMemoryContactRepository implements ContactRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryContactRepository.class);

    // mock the persistence level
    private final Map<String, Contact> contacts;

    public InMemoryContactRepository() {
        this.contacts = new ConcurrentHashMap<>();

        // preload mock data
        preload();
    }

    private void preload() {
        log.trace("Enter preload()");

        var contact = save(new Contact("Bob", "4242"));
        log.debug("Preload contact: {}", contact);

        contact = save(new Contact("Tom", "2134"));
        log.debug("Preload contact: {}", contact);
    }

    @Override
    public Contact save(Contact contact) {
        log.trace("save({})", contact);

        contacts.put(contact.getName(), contact);
        return contact;
    }

    @Override
    public Optional<Contact> findByName(String name) {
        log.trace("findByName({})", name);
        return Optional.ofNullable(contacts.get(name));
    }

    @Override
    public List<Contact> findAll() {
        log.trace("findAll()");
        return new ArrayList<>(contacts.values());
    }

    @Override
    public List<Contact> findContaining(String sub) {
        log.trace("findContaining({})", sub);

        return contacts.entrySet().stream()
                .filter(entry -> entry.getKey().contains(sub))
                .map(Map.Entry::getValue).toList();
    }

    @Override
    public void deleteByName(String name) {
        log.trace("deleteByName({})", name);
        contacts.remove(name);
    }

    @Override
    public void deleteAll() {
        log.trace("deleteAll()");
        contacts.clear();
    }
}
