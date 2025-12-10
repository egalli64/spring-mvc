/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A simple Spring Web MVC Controller
 */
@Controller
@RequestMapping("/m1/s3")
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    // A service used in this controller, injected by Spring
    private final CoderService svc;

    // implicit autowiring
    public SimpleController(CoderService svc) {
        this.svc = svc;
    }

    /**
     * The GetMapping annotation is a shortcut to @RequestMapping(method = RequestMethod.GET)
     */
    @GetMapping("/hello")
    public String helloThymeleaf() {
        log.trace("Enter helloThymeleaf()");

        // tell the ViewResolver which templates to call
        return "m1/hello";
    }

    /**
     * The method annotation completes the class-wide one:
     * <p>
     * the HTTP associated command is GET, the URL is /m1/s2/coder
     *
     * @return the name of the associated view
     */
    @GetMapping("/coder")
    public String coder(@RequestParam Integer id, Model model) {
        log.trace("Enter coders()");

        // using the service to get the coders
        var coder = svc.getCoder(id);

        // putting the data in the model
        model.addAttribute("id", id);
        model.addAttribute("coder", coder.orElse(null));

        // tell the ViewResolver which templates to call
        return "m1/s3";
    }
}
