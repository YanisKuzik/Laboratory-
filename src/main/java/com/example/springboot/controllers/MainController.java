package com.example.springboot.controllers;

import com.example.springboot.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private List<Product> products = Arrays.asList(
            new Product("Warior", 27000, "/Warior.png"),
            new Product("CCM", 28900, "/CCM.png"),
            new Product("Bauer", 24000, "/Bauer.png"),
            new Product("ЗаряД", 12400, "/ЗаряД.png")
    );

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", products);
        return "HockeyStick";
    }

    @GetMapping("/product/{name}")
    public String productDetails(@PathVariable String name, Model model) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                model.addAttribute("product", product);
                return "Stick-details";
            }
        }
        return "product-not-found";
    }
}