/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf Variable Expressions
 */
@Controller
@RequestMapping("/m3/s2")
public class VariableController {
    private static final Logger log = LoggerFactory.getLogger(VariableController.class);

    @GetMapping("/variable")
    public String variable(Model model) {
        log.trace("Enter variable()");

        model.addAttribute("name", "Tom");
        model.addAttribute("product", new Product("XYZ-42-J", 7));
        model.addAttribute("quantity", 6);

        return "m3/s2";
    }
}
