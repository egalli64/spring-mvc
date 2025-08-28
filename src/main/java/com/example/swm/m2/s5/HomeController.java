/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/m2/s5")
public class HomeController {
    private static Logger log = LogManager.getLogger(HomeController.class);

    @PostMapping("/login")
    public String login(@RequestParam String user, Model model) {
        log.traceEntry("login({})", user);

        if (user.isBlank()) {
            log.warn("default user used");
            user = "Guest";
        }

        model.addAttribute("user", user);
        return "m2/s5-home";
    }

    @GetMapping("/guest")
    public String guest(Model model) {
        log.traceEntry("guest()");

        model.addAttribute("user", "Guest");

        return "m2/s5-home";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status, Model model) {
        log.traceEntry("logout()");

        status.setComplete();
        model.addAttribute("user", null);
        return "m2/s5-home";
    }
}
