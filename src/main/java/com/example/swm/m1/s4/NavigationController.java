/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A simple Spring Web MVC Controller
 */
@Controller
@RequestMapping("/m1/s4")
public class NavigationController {
    private static final Logger log = LoggerFactory.getLogger(NavigationController.class);

    @GetMapping("/hello-raw")
    public String helloRaw() {
        log.trace("Enter helloRaw()");

        // forward to a static resource, not using the standard View Resolver
        return "forward:/m1/hello.html";
    }

    @GetMapping("/forwarder")
    public String forwarder() {
        log.trace("Enter forwarder()");

        // forward to another controller handler
        return "forward:/m1/s4/hello-raw";
    }

    @PostMapping("/redirector")
    public String redirector(@RequestParam String info) {
        log.trace("Enter redirector({})", info);

        // redirect to another controller handler
        return "redirect:/m1/s4/hello-raw";
    }
}
