package com.example.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
@RequestMapping("/fruits")
public class FruitController {

    private List<Fruit> fruits = new ArrayList<>();

    private static final Log log = LogFactory.getLog(FruitController.class);

    @GetMapping
    public String home(Model model) {

        // TODO: Add Sleuth logging here

        model.addAttribute("fruits", fruits);     // For the List view
        model.addAttribute("fruitForm", new Fruit()); // For the Form
        return "home";
    }

    @PostMapping
    public String createFruit(@ModelAttribute Fruit fruit) {
        fruits.add(fruit);
        return "redirect:/fruits";
    }

    //TODO: Add blank logging function
}
