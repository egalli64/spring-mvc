/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s2;

import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * A mock Spring Repository
 */
@Repository
public class CoderRepo {
    private static Logger log = LogManager.getLogger(CoderRepo.class);

    /** mock table CODER */
    Map<Integer, Coder> coders = Map.of( //
            103, new Coder(103, "Alexander", "Hunold", 8_993), //
            107, new Coder(107, "Diana", "Lorentz", 8_997));

    Optional<Coder> findById(Integer id) {
        log.traceEntry("findById({})", id);

        return Optional.ofNullable(coders.get(id));
    }
}
