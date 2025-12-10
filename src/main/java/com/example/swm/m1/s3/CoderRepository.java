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
    private final Map<Integer, Coder> coders = Map.of( //
            103, new Coder(103, "Alexander", "Hunold"), //
            107, new Coder(107, "Diana", "Lorentz"));

    Optional<Coder> findById(Integer id) {
        log.trace("Enter findById({})", id);

        return Optional.ofNullable(coders.get(id));
    }
}
