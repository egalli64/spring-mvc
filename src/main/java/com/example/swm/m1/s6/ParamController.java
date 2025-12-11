/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/m1/s6")
public class ParamController {
    private static final Logger log = LoggerFactory.getLogger(ParamController.class);

    private int checked(int count) {
        if (count < 1 || count > 10) {
            log.warn("Count was {}, defaulted to 1", count);
            return 1;
        } else {
            return count;
        }
    }

    @GetMapping("/param")
    public String param(@RequestParam int count, Model model) {
        log.trace("Enter param({})", count);

        count = checked(count);
        model.addAttribute("message", "hello!".repeat(count));
        return "m1/s6";
    }

    @GetMapping("/alias")
    public String alias(@RequestParam(name = "count") int i, Model model) {
        log.trace("Enter alias({})", i);

        i = checked(i);

        model.addAttribute("message", "hello!".repeat(i));
        return "m1/s6";
    }

    @GetMapping("/notRequired")
    public String notRequired(@RequestParam(required = false) Integer count, Model model) {
        log.trace("Enter notRequired({})", count);

        if (count != null) {
            count = checked(count);
            model.addAttribute("message", "hello!".repeat(count));
        }

        return "m1/s6";
    }

    /**
     * The use of Optional as parameter is seen as a hack.
     * Prefer the required=false approach when possible.
     */
    @GetMapping("/optional")
    public String optional(@RequestParam Optional<Integer> count, Model model) {
        log.trace("Enter optional({})", count);

        if (count.isPresent()) {
            int value = checked(count.get());
            model.addAttribute("message", "hello!".repeat(value));
        } else {
            model.addAttribute("message", "");
        }

        return "m1/s6";
    }

    @GetMapping("/defaulted")
    public String defaulted(@RequestParam(defaultValue = "1") int count, Model model) {
        log.trace("Enter defaulted({})", count);

        count = checked(count);
        model.addAttribute("message", "hello!".repeat(count));
        return "m1/s6";
    }

    @GetMapping("/array")
    public String array(@RequestParam int[] xs, Model model) {
        log.trace("Enter array({})", xs);

        model.addAttribute("message", "X values: " + Arrays.toString(xs));
        return "m1/s6";
    }

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password, Model model) {
        log.trace("Enter login({})", user);

        if (!user.isBlank() && user.equals(password)) {
            model.addAttribute("name", user);
        }

        return "m1/s6";
    }
}
