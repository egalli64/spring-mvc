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
@RequestMapping("/setter/region/all")
public class RegionSetterController {
    private static final Logger log = LoggerFactory.getLogger(RegionSetterController.class);

    private RegionService svc;

    @Autowired
    public void setRepo(RegionService svc) {
        this.svc = svc;
    }

    @GetMapping
    public String getAll(Model model) {
        log.trace("Enter getAll()");

        model.addAttribute("regions", svc.allRegions());

        return "region-viewer";
    }
}
