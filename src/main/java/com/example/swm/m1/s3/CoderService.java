/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * A very simple Spring Service
 */
@Service
public class CoderService {
    private static final Logger log = LoggerFactory.getLogger(CoderService.class);

    // A repository is used in this service, injected by Spring
    private final CoderRepository repo;

    // implicit autowiring
    public CoderService(CoderRepository repo) {
        this.repo = repo;
    }

    // at the moment the service layer is just a pass-through to the repository
    public Optional<Coder> getCoder(Long id) {
        log.trace("Enter getCoder({})", id);

        return repo.findById(id);
    }
}
