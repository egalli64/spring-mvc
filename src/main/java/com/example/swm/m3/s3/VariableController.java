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
 * Thymeleaf Variable Expressions
 */
@Controller
@RequestMapping("/m3/s3")
public class VariableController {
    private static Logger log = LogManager.getLogger(VariableController.class);

    @GetMapping("/variable")
    public String variable(Model model) {
        log.traceEntry("variable()");

        model.addAttribute("name", "Tom");
        model.addAttribute("product", new Product("XYZ-42-J", 7));
        model.addAttribute("quantity", 6);

        return "m3/s3";
    }
}
