/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.repository;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.example.swm.m1.s4.CoderRepository;
import com.example.swm.model.Region;

@Repository
public class RegionRepository {
    private static Logger log = LogManager.getLogger(CoderRepository.class);

    /** mock table REGION */
    private final Map<Integer, Region> regions = Map.of(1, new Region(1, "Europe"), 2, new Region(2, "Americas"));

    public Iterable<Region> findAll() {
        log.traceEntry("findAll()");

        return regions.values();
    }
}
