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
@RequestMapping("/field/region/all")
public class RegionFieldController {
    private static final Logger log = LogManager.getLogger(RegionFieldController.class);

    @Autowired
    private RegionService svc;

    @GetMapping
    public String getAll(Model model) {
        log.traceEntry("getAll()");

        model.addAttribute("regions", svc.allRegions());

        return "region-viewer";
    }
}
