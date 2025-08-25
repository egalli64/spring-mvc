/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.example.swm.model.Region;
import com.example.swm.repository.RegionRepository;

/**
 * A very simple Spring Service
 */
@Service
public class RegionService {
    private static Logger log = LogManager.getLogger(RegionService.class);

    /** A repository is used in this service, injected by Spring */
    private RegionRepository repo;

    /** unique ctor, implicitly autowired */
    public RegionService(RegionRepository repo) {
        this.repo = repo;
    }

    public Iterable<Region> allRegions() {
        log.traceEntry("allRegions()");

        return repo.findAll();
    }
}
