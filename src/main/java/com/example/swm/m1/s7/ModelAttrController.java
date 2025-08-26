/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s7;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m1/s7")
public class ModelAttrController {
    private static Logger log = LogManager.getLogger(ModelAttrController.class);

    @ModelAttribute
    public void extraInfo(Model model) {
        model.addAttribute("extra", true);
        model.addAttribute("time", LocalTime.now());
        model.addAttribute("users", Set.of("Tom", "Bob", "Joe"));
    }

    @ModelAttribute("teams")
    public List<String> teams() {
        return List.of("Alpha", "Beta", "Gamma");
    }

    @GetMapping("/info")
    public String info(@ModelAttribute User user, Model model) {
        log.traceEntry("info({})", user);

        if (user.getPassword() == null) {
            log.info("Good, no password should be passed by HTTP GET");
        } else {
            log.warn("Very bad! Use HTTP POST for sensitive data");
        }

        model.addAttribute("message", "Hello");
        return "m1/s7";
    }
}
