/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s5;

import java.util.Arrays;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/m1/s5")
public class ParamController {
    private static Logger log = LogManager.getLogger(ParamController.class);

    @GetMapping("/param")
    public String param(@RequestParam int count, Model model) {
        log.traceEntry("param({})", count);

        if (count < 1 || count > 10) {
            log.warn(String.format("Count was %d, defaulted to 1", count));
            count = 1;
        }

        model.addAttribute("message", "hello!".repeat(count));
        return "m1/s5";
    }

    @GetMapping("/alias")
    public String alias(@RequestParam(name = "count") int i, Model model) {
        log.traceEntry("alias({})", i);

        if (i < 1 || i > 10) {
            log.warn(String.format("Count was %d, defaulted to 1", i));
            i = 1;
        }

        model.addAttribute("message", "hello!".repeat(i));
        return "m1/s5";
    }

    @GetMapping("/notRequired")
    public String notRequired(@RequestParam(required = false) Integer count, Model model) {
        log.traceEntry("notRequired({})", count);

        if (count != null) {
            if (count < 1 || count > 10) {
                log.warn(String.format("Count was %d, defaulted to 1", count));
                count = 1;
            }

            model.addAttribute("message", "hello!".repeat(count));
        }

        return "m1/s5";
    }

    @GetMapping("/optional")
    public String optional(@RequestParam Optional<Integer> count, Model model) {
        log.traceEntry("optional({})", count);

        if (count.isPresent()) {
            int value = count.get();
            if (value < 1 || value > 10) {
                log.warn(String.format("Count was %d, defaulted to 1", value));
                value = 1;
            }
            model.addAttribute("message", "hello!".repeat(value));
        } else {
            model.addAttribute("message", "");
        }

        return "m1/s5";
    }

    @GetMapping("/defaulted")
    public String defaulted(@RequestParam(defaultValue = "1") int count, Model model) {
        log.traceEntry("defaulted({})", count);

        if (count < 1 || count > 10) {
            log.warn(String.format("Count was %d, defaulted to 1", count));
            count = 1;
        }

        model.addAttribute("message", "hello!".repeat(count));
        return "m1/s5";
    }

    @GetMapping("/array")
    public String array(@RequestParam int[] xs, Model model) {
        log.traceEntry("array({})", xs);

        model.addAttribute("message", "X values: " + Arrays.toString(xs));
        return "m1/s5";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password, Model model) {
        log.traceEntry("login({})", user);

        if (!user.isBlank() && user.equals(password)) {
            model.addAttribute("name", user);
        }

        return "m1/s5";
    }
}
