package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    private GreetingService greetingService;
//    private static final String template = "Hello, %s %s!";
//    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = {"/", "/message", ""})
    public Greeting greetingMessage(@RequestParam(required = false,defaultValue =  "") String firstName, @RequestParam(required = false,defaultValue =  "") String lastName) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, firstName, lastName));
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    return greetingService.addGreeting(user);
    }
}