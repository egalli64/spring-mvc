/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s3;

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
@RequestMapping("/m2/s3")
public class UserController {
    private static Logger log = LogManager.getLogger(UserController.class);

    @GetMapping("/new")
    public String showForm(Model model) {
        log.traceEntry("showForm()");
        model.addAttribute("user", new User());
        return "m2/s3-form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        log.traceEntry("create()");
        if (bindingResult.hasErrors()) {
            return "m2/s3-form";
        }

        // TODO: store the user
        log.info("Validated user created: {}", user);

        return "redirect:/m2/s3/success";
    }

    @GetMapping("/success")
    public String success() {
        log.traceEntry("success()");
        return "m2/s3-success";
    }
}
