/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.controller;

import com.example.swm.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctor/region/all")
public class RegionCtorController {
    private static final Logger log = LoggerFactory.getLogger(RegionCtorController.class);

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
        log.trace("Enter getAll()");

        model.addAttribute("regions", svc.allRegions());

        return "region-viewer";
    }
}
