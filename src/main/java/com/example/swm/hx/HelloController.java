/*
 * Spring Boot Web MVC tutorial - Hypermedia System: htmx
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * A simple Spring Web MVC Controller
 */
@Controller
@RequestMapping("/hx")
public class HelloController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        log.trace("Enter hello()");

        return LocalDateTime.now().toString();
    }
}
