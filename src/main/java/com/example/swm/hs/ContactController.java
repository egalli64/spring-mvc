/*
 * Spring Boot Web MVC tutorial - Hypermedia System
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hs;

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
@RequestMapping("/hs")
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService svc;

    public ContactController(ContactService svc) {
        this.svc = svc;
    }

    @GetMapping("/")
    public String home() {
        log.trace("Enter home()");

        return "redirect:contacts";
    }

    @GetMapping("/contacts")
    public String contacts(@RequestParam(required = false) String query, Model model) {
        log.trace("Enter contacts({})", query);

        if (query == null) {
            model.addAttribute("contacts", svc.getContacts());
        } else {
            model.addAttribute("contacts", svc.search(query));
            model.addAttribute("query", query);
        }

        return "hs/contacts";
    }

    @GetMapping("/contacts/new")
    public String newContact() {
        log.trace("Enter newContact()");

        return "hs/new";
    }
}
