/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s1;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Welcome to Thymeleaf
 */
@Controller
@RequestMapping("/m3/s1")
public class WelcomeController {
    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/welcome")
    public String welcome(@RequestParam(required = false) String name, Model model) {
        log.trace("Enter welcome({})", name);

        if (name == null || name.isEmpty()) {
            name = "Guest";
            log.info("No name specified, using '{}'", name);
        }

        model.addAttribute("name", name);
        model.addAttribute("time", LocalDateTime.now());

        return "m3/s1";
    }
}
