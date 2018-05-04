package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/")
public class HomeController {

    private static final Log log = LogFactory.getLog(HomeController.class);

    @Autowired
    public HomeController() {
    }

    @GetMapping
    public String home() {
        // TODO: Add Sleuth logging here

        return "home";
    }

    //TODO: Add blank logging function

}
