/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m3.s6;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Other Thymeleaf attributes
 */
@Controller
@RequestMapping("/m3/s6")
public class OtherController {
    private static Logger log = LogManager.getLogger(OtherController.class);

    @GetMapping("/utext")
    public String utext(Model model) {
        log.traceEntry("utext()");

        model.addAttribute("malicious", "<script>alert('Hello!');</script>");

        return "m3/s6-utext";
    }

    @GetMapping("/style")
    public String style(Model model) {
        log.traceEntry("style()");

        model.addAttribute("active", ThreadLocalRandom.current().nextBoolean());
        model.addAttribute("color", "purple");

        return "m3/s6-style";
    }

    @GetMapping("/attr")
    public String attr(Model model) {
        log.traceEntry("attr()");

        model.addAttribute("admin", ThreadLocalRandom.current().nextBoolean());

        return "m3/s6-attr";
    }
}
