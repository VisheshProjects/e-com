package com.ecom.hello_ms.controller;

import com.ecom.hello_ms.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello %s!";

    @GetMapping("/greetings")
    public Greeting greetings(@RequestParam(value = "name", defaultValue = "World") String name){
        Greeting record = new Greeting(counter.incrementAndGet(),String.format(template,name));
        return record;
    }

    @GetMapping("/all-greetings")
    public List<Greeting> getAllGreetings(){

        return null;
    }

}
