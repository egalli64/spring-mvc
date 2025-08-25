/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.swm.service.RegionService;

@Controller
@RequestMapping("/ctor/region/all")
public class RegionCtorController {
    private static final Logger log = LogManager.getLogger(RegionCtorController.class);

    private final RegionService svc;

    /**
     * This is the ctor select by Spring to initialize this component
     */
    @Autowired
    public RegionCtorController(RegionService svc) {
        this.svc = svc;
    }

    /**
     * When there is more than one ctor, the @Autowired annotation is required
     */
    public RegionCtorController(RegionService svc, String message) {
        log.info(message);
        this.svc = svc;
    }

    @GetMapping
    public String getAll(Model model) {
        log.traceEntry("getAll()");

        model.addAttribute("regions", svc.allRegions());

        return "region-viewer";
    }
}
