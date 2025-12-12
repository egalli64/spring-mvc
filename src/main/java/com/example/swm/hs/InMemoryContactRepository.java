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
    private final Map<Long, Contact> coders;
    private final AtomicLong seq;

    public InMemoryContactRepository() {
        this.coders = new ConcurrentHashMap<>();
        this.seq = new AtomicLong(0);

        // preload mock data
        preload();
    }

    private void preload() {
        log.trace("Enter preload()");

        var contact = save(new Contact("Bob"));
        log.debug("Preload contact: {}", contact);

        contact = save(new Contact("Tom"));
        log.debug("Preload contact: {}", contact);
    }

    @Override
    public Contact save(Contact contact) {
        log.trace("save({})", contact);
        if (contact.getId() == null) {
            contact.setId(seq.incrementAndGet());
        }

        coders.put(contact.getId(), contact);
        return contact;
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.trace("findById({})", id);
        return Optional.ofNullable(coders.get(id));
    }

    @Override
    public List<Contact> findAll() {
        log.trace("findAll()");
        return new ArrayList<>(coders.values());
    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById({})", id);
        coders.remove(id);
    }

    @Override
    public void deleteAll() {
        log.trace("deleteAll()");
        coders.clear();
    }
}
