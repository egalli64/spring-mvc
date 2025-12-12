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

import java.util.ArrayList;
import java.util.List;

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
    public String contacts(@RequestParam(required = false) Long id, Model model) {
        log.trace("Enter contacts({})", id);

        if (id == null) {
            model.addAttribute("contacts", svc.getContacts());
        } else {
            List<Contact> contacts = new ArrayList<>(1);
            svc.getContact(id).ifPresent(contacts::add);
            model.addAttribute("contacts", contacts);
            model.addAttribute("id", id);
        }

        return "hs/contacts";
    }
}
