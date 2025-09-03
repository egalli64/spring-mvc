/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s3;

import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/m2/s3")
public class SessionController {
    private static Logger log = LogManager.getLogger(SessionController.class);

    @PostMapping("/login")
    public String login(@RequestParam String user, HttpSession session) {
        log.traceEntry("login({})", user);
        if (user.isBlank()) {
            log.warn("default user used");
            session.setAttribute("user", "Guest");
        } else {
            session.setAttribute("user", user);
        }
        return "m2/s3";
    }

    @GetMapping("/guest")
    public String guest(HttpSession session) {
        log.traceEntry("guest()");

        session.setAttribute("user", "Guest");

        return "m2/s3";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.traceEntry("logout()");
        session.invalidate();
        return "m2/s3";
    }
}
