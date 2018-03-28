package com.example.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/fruits")
public class FruitController {

    private List<Fruit> fruits = new ArrayList<>();

    @GetMapping
    public String home(Model model) {
        model.addAttribute("fruits", fruits);     // For the List view
        model.addAttribute("fruitForm", new Fruit()); // For the Form
        return "home";
    }

    // TODO other mappings here
    @PostMapping
    public String createFruit(@ModelAttribute Fruit fruit) {
        fruits.add(fruit);
        return "redirect:/fruits";
    }

    @DeleteMapping("/:id")
    public String deleteFruit(@PathVariable("id") int fruitId) {
        fruits.remove(fruitId);
        return "redirect:/fruits";
    }

}