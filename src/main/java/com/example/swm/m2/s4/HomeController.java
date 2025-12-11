/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
@RequestMapping("/m2/s4")
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @PostMapping("/login")
    public String login(@RequestParam String user, Model model) {
        log.trace("Enter login({})", user);

        if (user.isBlank()) {
            log.warn("default user used");
            user = "Guest";
        }

        model.addAttribute("user", user);
        return "m2/s4-home";
    }

    @GetMapping("/guest")
    public String guest(Model model) {
        log.trace("Enter guest()");

        model.addAttribute("user", "Guest");

        return "m2/s4-home";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status, Model model) {
        log.trace("Enter logout()");

        status.setComplete();
        model.addAttribute("user", null);
        return "m2/s4-home";
    }
}
