/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf Standard Expressions
 */
@Controller
@RequestMapping("/m3/s3")
public class ExpressionController {
    private static Logger log = LogManager.getLogger(ExpressionController.class);

    @GetMapping("/selection")
    public String selection(Model model) {
        log.traceEntry("selection()");

        model.addAttribute("user", new User("Tom", "Smith", 42));

        return "m3/s3-selection";
    }

    @GetMapping("/message")
    public String message(Model model) {
        log.traceEntry("message()");

        model.addAttribute("user", new User("Tom", "Smith", 42));

        return "m3/s3-message";
    }

    @GetMapping("/link")
    public String link() {
        log.traceEntry("link()");

        return "m3/s3-link";
    }
}
