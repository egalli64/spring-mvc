/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Thymeleaf Standard Expressions
 */
@Controller
@RequestMapping("/m3/s3")
public class ExpressionController {
    private static final Logger log = LoggerFactory.getLogger(ExpressionController.class);

    @GetMapping("/selection")
    public String selection(Model model) {
        log.trace("Enter selection()");

        model.addAttribute("user", new User("Tom", "Smith", 42));

        return "m3/s3-selection";
    }

    @GetMapping("/selection-form")
    public String selectionForm(Model model) {
        log.trace("Enter selectionForm()");

        model.addAttribute("user", new User("Tom", "Smith", 42));

        return "m3/s3-selection-form";
    }

    @GetMapping("/empty-form")
    public String emptyForm(Model model) {
        log.trace("Enter emptyForm()");

        model.addAttribute("user", new User());

        return "m3/s3-selection-form";
    }

    @PostMapping("/save-user")
    public String form(@ModelAttribute User user) {
        log.trace("Enter form({})", user);

        // assume user is made persistent

        return "redirect:/m3/s3/empty-form";
    }

    @GetMapping("/message")
    public String message(Model model) {
        log.trace("Enter message()");

        model.addAttribute("user", new User("Tom", "Smith", 42));

        return "m3/s3-message";
    }

    @GetMapping("/link")
    public String link() {
        log.trace("Enter link()");

        return "m3/s3-link";
    }

    @PostMapping("/link-feedback")
    public String linkFeedback(@RequestParam String name) {
        log.trace("Enter linkFeedback({})", name);

        return "redirect:/";
    }
}
