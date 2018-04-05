package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    public HomeController() {
    }

    @GetMapping
    public String home(Model model) {
        return "home";
    }

}
