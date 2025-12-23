/*
 * Spring Boot Web MVC tutorial - Hypermedia System
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hx;

import com.example.swm.hs.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A simple htmx-based Spring Web MVC Controller
 */
@Controller
@RequestMapping("/hx")
public class HxContactController {
    private static final Logger log = LoggerFactory.getLogger(HxContactController.class);

    private final ContactService svc;

    public HxContactController(ContactService svc) {
        this.svc = svc;
    }

    @GetMapping("/contacts")
    @ResponseBody
    public String contacts(@RequestParam(required = false) String query) {
        log.trace("Enter contacts({})", query);

        // TODO: Use a Thymeleaf fragment
        if (query == null) {
            return svc.getContacts().toString();
        } else {
            return svc.search(query).toString();
        }
    }
}
