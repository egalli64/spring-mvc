/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m1/s7")
public class MockLoginController {
    private static Logger log = LogManager.getLogger(MockLoginController.class);

    @GetMapping("/user")
    public String user(Model model) {
        log.traceEntry("user()");

        // get the user, extract the required information, put them in the model

        model.addAttribute("message", "Hello");
        model.addAttribute("user", new User("Bob", "bob@example.com"));
        return "m1/s7";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        log.traceEntry("login({})", user);

        if (user.getPassword() == null) {
            log.warn("Bad, we need to validate user!");
        } else {
            log.info("We use HTTP POST for sensitive data");
        }

        // Post-Redirect-Get pattern
        return "redirect:/m1/s7/user";
    }
}
