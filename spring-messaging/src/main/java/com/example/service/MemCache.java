package com.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MemCache {

    private AtomicLong counter = new AtomicLong(0);
    private List<Ping> messages = new ArrayList<>();

    public long getCount() {
        return counter.get();
    }

    public void incr() {
        counter.incrementAndGet();
    }

    public void addMessage(Ping ping) {
        this.messages.add(ping);
    }

    public List<Ping> getMessages() {
        return this.messages;
    }
}
