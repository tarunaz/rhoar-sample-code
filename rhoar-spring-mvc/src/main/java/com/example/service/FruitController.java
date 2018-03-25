package com.example.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/fruits")
public class FruitController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("fruits", new Fruit("apple", 1));

        return "index";
    }

}