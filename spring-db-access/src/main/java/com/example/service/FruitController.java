package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(value = "/api/fruits")
public class FruitController {

    private FruitRepository repository;

    @Autowired
    public FruitController(FruitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public List<Fruit> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String createFruit(@RequestBody(required = false) Fruit fruit) {
        repository.save(fruit);
        return "redirect:/";
    }

}