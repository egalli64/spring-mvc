/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * A very simple Spring service
 */
@Service
public class CoderSvc {
    private static Logger log = LogManager.getLogger(CoderSvc.class);

    // A repository is used in this service, injected by Spring
    private CoderRepo repo;

    // implicit autowiring
    public CoderSvc(CoderRepo repo) {
        this.repo = repo;
    }

    public Coder getCoder(Integer id) {
        log.traceEntry("getCoder({})", id);

        var opt = repo.findById(id);

        if (opt.isEmpty()) {
            log.warn("Can't find coder {}", id);
            return null;
        } else {
            return opt.get();
        }
    }
}
