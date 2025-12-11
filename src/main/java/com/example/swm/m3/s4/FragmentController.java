/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf Fragment Expressions
 */
@Controller
@RequestMapping("/m3/s4")
public class FragmentController {
    private static final Logger log = LoggerFactory.getLogger(FragmentController.class);

    @GetMapping("/fragment")
    public String fragment(Model model) {
        log.trace("Enter fragment()");

        model.addAttribute("name", "Bob");

        return "m3/s4";
    }
}
