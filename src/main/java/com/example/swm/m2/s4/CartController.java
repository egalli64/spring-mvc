/*
 * Spring Boot Web MVC tutorial
 *
 * https://github.com/egalli64/spring-mvc
 */
package com.example.swm.m2.s4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
@RequestMapping("/m2/s4")
public class CartController {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    private static final List<String> PRODUCTS = List.of("Apple", "Banana", "Orange", "Grape");

    @ModelAttribute("cart")
    public List<String> cartInitializer() {
        log.trace("Enter cartInitializer()");

        return new ArrayList<>();
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        log.trace("Enter shop()");
        model.addAttribute("products", PRODUCTS);

        return "m2/s4-shop";
    }

    @PostMapping("/add")
    public String add(@RequestParam String product, @SessionAttribute List<String> cart) {
        log.trace("Enter add({})", product);

        cart.add(product);
        return "redirect:/m2/s4/shop";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String product, @SessionAttribute List<String> cart) {
        log.trace("Enter remove({})", product);

        cart.remove(product);
        return "redirect:/m2/s4/shop";
    }

    @GetMapping("/checkout")
    public String checkout(@SessionAttribute List<String> cart) {
        log.trace("Enter checkout() for {}", cart);

        if (cart == null || cart.isEmpty()) {
            log.warn("No cart!");
        }

        return "m2/s4-checkout";
    }

    @GetMapping("/clear")
    public String clear(SessionStatus status, Model model) {
        log.trace("Enter clear()");

        status.setComplete();
        model.addAttribute("cart", null);

        return "redirect:/m2/s4/shop";
    }
}
