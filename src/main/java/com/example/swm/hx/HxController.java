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
 * A simple Spring Web MVC Controller for htmx
 */
@Controller
@RequestMapping("/hx")
public class HxController {
    private static final Logger log = LoggerFactory.getLogger(HxController.class);

    @GetMapping("/")
    public String home() {
        log.trace("Enter home()");
        return "hx/home";
    }

    @GetMapping("/hx-get")
    public String getHxGet() {
        log.trace("Enter getHxGet()");
        return "hx/hx-get";
    }

    @GetMapping("/hx-swap")
    public String getHxSwap() {
        log.trace("Enter getHxSwap()");
        return "hx/hx-swap";
    }

    @GetMapping("/get-form")
    public String getForm() {
        log.trace("Enter getForm()");
        return "hx/get-form";
    }

    @GetMapping("/hx-trigger")
    public String getHxTrigger() {
        log.trace("Enter getHxTrigger()");
        return "hx/hx-trigger";
    }

    @GetMapping("/get-text")
    @ResponseBody
    public String plainGetter() {
        log.trace("Enter plainGetter()");

        return LocalDateTime.now().toString();
    }


    @GetMapping("/get-paragraph")
    @ResponseBody
    public String paragraphGetter() {
        log.trace("Enter paragraphGetter()");

        return String.format("<p>%s</p>", LocalDateTime.now());
    }
}
