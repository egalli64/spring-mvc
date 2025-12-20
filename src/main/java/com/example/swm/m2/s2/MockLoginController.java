/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m2/s2")
public class MockLoginController {
    private static final Logger log = LoggerFactory.getLogger(MockLoginController.class);

    @GetMapping("/user")
    public String user(Model model) {
        log.trace("Enter user()");

        // TODO: get the user, extract the required information, put them in the model

        model.addAttribute("message", "Hello");
        model.addAttribute("user", new User("Bob", "bob@example.com"));
        return "m2/s2";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        log.trace("Enter login({})", user);

        // no validation, we have no guarantee of any user field being "good"
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            log.error("Bad, we need to validate user!");
            throw new IllegalArgumentException("Please enter username and password!");
        } else {
            log.info("We use HTTP POST for sensitive data");
        }

        // Post-Redirect-Get pattern
        return "redirect:/m2/s2/user";
    }
}
