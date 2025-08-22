/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A simple Spring MVC controller
 */
@Controller
@RequestMapping("/m1/s2")
public class CoderCtr {
    private static Logger log = LogManager.getLogger(CoderCtr.class);

    // A service used in this controller, injected by Spring
    private CoderSvc svc;

    // implicit autowiring
    public CoderCtr(CoderSvc svc) {
        this.svc = svc;
    }

    /**
     * The method annotation completes the class-wide one:
     * 
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
        model.addAttribute("coder", coder);

        // tell the ViewResolver which templates to call
        return "m1/s2";
    }
}
