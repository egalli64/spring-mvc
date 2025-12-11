/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s5;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Thymeleaf conditionals and iteration
 */
@Controller
@RequestMapping("/m3/s5")
public class ConditionalController {
    private static final Logger log = LoggerFactory.getLogger(ConditionalController.class);

    @GetMapping("/elvis")
    public String elvis(Model model) {
        log.trace("Enter elvis()");

        model.addAttribute("nickname", "Doc");

        return "m3/s5-elvis";
    }

    @GetMapping("/th-if")
    public String thIf(Model model) {
        log.trace("Enter thIf()");

        model.addAttribute("user", new User("Bob", true, true));

        return "m3/s5-th-if";
    }

    @GetMapping("/th-unless")
    public String thUnless(Model model) {
        log.trace("Enter thUnless()");

        model.addAttribute("user", new User("Bob", false, false));

        return "m3/s5-th-unless";
    }

    @GetMapping("/th-each")
    public String thEach(Model model) {
        log.trace("Enter thEach()");

        var users = List.of(new User("Al", true, false), new User("Bob", false, false), new User("Cy", false, true));
        log.debug("Users are {}", users);

        model.addAttribute("users", users);

        return "m3/s5-th-each";
    }
}
