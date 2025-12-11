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
@RequestMapping("/field/region/all")
public class RegionFieldController {
    private static final Logger log = LoggerFactory.getLogger(RegionFieldController.class);

    @Autowired
    private RegionService svc;

    @GetMapping
    public String getAll(Model model) {
        log.trace("Enter getAll()");

        model.addAttribute("regions", svc.allRegions());

        return "region-viewer";
    }
}
