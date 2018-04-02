package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FruitReceiver {

    private FruitRepository repository;

    @Autowired
    public FruitReceiver(FruitRepository repository) {
        this.repository = repository;
    }

    @JmsListener(destination = "fruitMailbox")
    public void receiveMessage(Fruit fruit) {
        System.out.println("Received: " + fruit);
        repository.save(fruit);
    }

}
