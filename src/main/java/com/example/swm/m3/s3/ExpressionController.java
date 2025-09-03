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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/selection-form")
    public String selectionForm(Model model) {
        log.traceEntry("selectionForm()");

        model.addAttribute("user", new User("Tom", "Smith", 42));

        return "m3/s3-selection-form";
    }

    @GetMapping("/empty-form")
    public String emptyForm(Model model) {
        log.traceEntry("emptyForm()");

        model.addAttribute("user", new User());

        return "m3/s3-selection-form";
    }

    @PostMapping("/save-user")
    public String form(@ModelAttribute User user) {
        log.traceEntry("form({})", user);

        // assume user is made persistent

        return "redirect:/m3/s3/empty-form";
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

    @PostMapping("/link-feedback")
    public String linkFeedback(@RequestParam String name) {
        log.traceEntry("linkFeedback({})", name);

        return "redirect:/";
    }

}
