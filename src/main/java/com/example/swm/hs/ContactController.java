/*
 * Spring Boot Web MVC tutorial - Hypermedia System
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.hs;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showNew(Model model) {
        log.trace("Enter showNew()");
        model.addAttribute("contact", new Contact());
        return "hs/new";
    }

    /**
     * Post - Validate - Redisplay (if validation fails)
     * Post - Redirect - Get (in case of success)
     */
    @PostMapping("/contacts/new")
    public String submitNew(@Valid @ModelAttribute Contact contact, BindingResult br, RedirectAttributes ra) {
        log.trace("Enter submitNew({})", contact);

        if (br.hasErrors()) {
            return "hs/new";
        } else {
            contact = svc.save(contact);
            log.debug("Contact saved with id {}", contact.getId());
            ra.addFlashAttribute("flash", "New contact created for " + contact.getName());
            return "redirect:/hs/contacts";
        }
    }

    @GetMapping("/contacts/{id}")
    public String view(@PathVariable Long id, Model model) {
        log.trace("Enter view({})", id);

        model.addAttribute("contact", svc.getContact(id).orElse(null));
        return "hs/view";
    }

    @GetMapping("/contacts/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        log.trace("Enter showEdit({})", id);

        model.addAttribute("contact", svc.getContact(id).orElse(null));
        return "hs/edit";
    }

    /**
     * Post - Validate - Redisplay (if validation fails)
     * Post - Redirect - Get (in case of success)
     */
    @PostMapping("/contacts/{id}/edit")
    public String submitEdit(@Valid @ModelAttribute Contact contact, BindingResult br, RedirectAttributes ra) {
        log.trace("Enter submitEdit({})", contact);

        if (br.hasErrors()) {
            return "hs/edit";
        } else {
            contact = svc.save(contact);
            log.debug("Contact changes saved for id {}", contact.getId());
            ra.addFlashAttribute("flash", "Details changed for " + contact.getName());
            return "redirect:/hs/contacts";
        }
    }

    /**
     * Using GET to let the frontend use a link for it :(
     */
    @GetMapping("/contacts/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        log.trace("Enter delete({})", id);

        svc.delete(id);
        ra.addFlashAttribute("flash", "Contact deleted");

        return "redirect:/hs/contacts";
    }
}
