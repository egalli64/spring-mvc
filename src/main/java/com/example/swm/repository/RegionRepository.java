/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.repository;

import com.example.swm.model.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RegionRepository {
    private static final Logger log = LoggerFactory.getLogger(RegionRepository.class);

    /**
     * mock table REGION
     */
    private final Map<Integer, Region> regions = Map.of(1, new Region(1, "Europe"), 2, new Region(2, "Americas"));

    public Iterable<Region> findAll() {
        log.trace("Enter findAll()");

        return regions.values();
    }
}
