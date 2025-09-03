/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m4.s2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/m4/s2")
public class ValidationController {
    private static Logger log = LogManager.getLogger(ValidationController.class);

    @GetMapping("/new")
    public String showForm(Model model) {
        log.traceEntry("showForm()");
        model.addAttribute("user", new User());
        return "m4/s2-form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        log.traceEntry("create()");
        if (bindingResult.hasErrors()) {
            return "m4/s2-form";
        }

        // TODO: store the user
        log.info("Validated user created: {}", user);

        return "redirect:/m4/s2/success";
    }

    @GetMapping("/success")
    public String success() {
        log.traceEntry("success()");
        return "m4/s2-success";
    }
}
