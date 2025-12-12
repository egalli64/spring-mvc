/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

/**
 * A mock Spring Repository
 */
@Repository
public class CoderRepository {
    private static final Logger log = LoggerFactory.getLogger(CoderRepository.class);

    /**
     * mock table CODER
     */
    private final Map<Long, Coder> coders = Map.of( //
            103L, new Coder(103L, "Alexander", "Hunold"), //
            107L, new Coder(107L, "Diana", "Lorentz"));

    Optional<Coder> findById(Long id) {
        log.trace("Enter findById({})", id);

        return Optional.ofNullable(coders.get(id));
    }
}
