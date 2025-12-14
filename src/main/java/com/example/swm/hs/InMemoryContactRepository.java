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
import java.util.concurrent.atomic.AtomicLong;

/**
 * A simple mockingly concrete repository
 */
@Repository
public class InMemoryContactRepository implements ContactRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryContactRepository.class);

    // mock the persistence level
    private final Map<Long, Contact> contacts;
    private final AtomicLong seq;


    public InMemoryContactRepository() {
        this.contacts = new ConcurrentHashMap<>();
        this.seq = new AtomicLong(0);

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

        if (contact.getId() == null) {
            contact.setId(seq.incrementAndGet());
        }

        contacts.put(contact.getId(), contact);
        return contact;
    }

    @Override
    public Optional<Contact> find(Long id) {
        log.trace("find({})", id);
        return Optional.ofNullable(contacts.get(id));
    }

    @Override
    public List<Contact> findAll() {
        log.trace("findAll()");
        return new ArrayList<>(contacts.values());
    }

    @Override
    public List<Contact> findContaining(String sub) {
        log.trace("findContaining({})", sub);

        return contacts.values().stream().filter(x -> x.getName().contains(sub)).toList();
    }

    @Override
    public void delete(Long id) {
        log.trace("delete({})", id);
        contacts.remove(id);
    }

    @Override
    public void deleteAll() {
        log.trace("deleteAll()");
        contacts.clear();
    }
}
