/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m1.s4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * A Controller with Models
 */
@Controller
@RequestMapping("/m1/s4")
public class ModelController {
    private static Logger log = LogManager.getLogger(ModelController.class);

    @GetMapping("/hello")
    public String helloModel(Model model) {
        log.trace("helloModel()");
        model.addAttribute("message", "A message by Model");
        return "m1/s4";
    }

    @GetMapping("/hello2")
    public String helloModelMap(ModelMap model) {
        log.trace("helloModelMap()");
        model.addAttribute("message", "A message by Model Map");
        return "m1/s4";
    }

    @GetMapping("/hello3")
    public ModelAndView helloModelAndView(ModelAndView mav) {
        log.trace("helloModelAndView()");
        mav.setViewName("m1/s4");
        mav.addObject("message", "A message by ModelAndView");
        return mav;
    }

    @GetMapping("/hello4")
    public ModelAndView helloModelAndViewLocal() {
        log.trace("helloModelAndViewLocal()");
        ModelAndView mav = new ModelAndView("m1/s4");
        mav.addObject("message", "A message by ModelAndView (local)");
        return mav;
    }
}
