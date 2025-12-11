/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.service;

import com.example.swm.model.Region;
import com.example.swm.repository.RegionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A very simple Spring Service
 */
@Service
public class RegionService {
    private static final Logger log = LoggerFactory.getLogger(RegionService.class);

    /**
     * A repository is used in this service, injected by Spring
     */
    private final RegionRepository repo;

    /**
     * unique ctor, implicitly autowired
     */
    public RegionService(RegionRepository repo) {
        this.repo = repo;
    }

    public Iterable<Region> allRegions() {
        log.trace("Enter allRegions()");

        return repo.findAll();
    }
}
