/*
 * Spring Boot Web MVC tutorial 
 * 
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s4;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("cart")
@RequestMapping("/m2/s4")
public class CartController {
    private static Logger log = LogManager.getLogger(CartController.class);

    private static final List<String> PRODUCTS = List.of("Apple", "Banana", "Orange", "Grape");

    @ModelAttribute("cart")
    public List<String> cartInitializer() {
        log.traceEntry("cartInitializer()");

        return new ArrayList<>();
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        log.traceEntry("shop()");
        model.addAttribute("products", PRODUCTS);

        return "m2/s4-shop";
    }

    @PostMapping("/add")
    public String add(@RequestParam String product, @SessionAttribute List<String> cart) {
        log.traceEntry("add({})", product);

        cart.add(product);
        return "redirect:/m2/s4/shop";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String product, @SessionAttribute List<String> cart) {
        log.traceEntry("remove({})", product);

        cart.remove(product);
        return "redirect:/m2/s4/shop";
    }

    @GetMapping("/clear")
    public String clear(SessionStatus status, Model model) {
        log.traceEntry("clear()");

        status.setComplete();
        model.addAttribute("cart", null);

        return "redirect:/m2/s4/shop";
    }
}
