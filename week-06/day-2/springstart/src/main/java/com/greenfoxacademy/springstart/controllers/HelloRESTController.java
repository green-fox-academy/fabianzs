package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloRESTController {

    private AtomicLong id = new AtomicLong(1);

    @RequestMapping(value="/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam("name") String name) {
        return new Greeting(id.getAndIncrement(),"Hello, " + name + "!");
    }
}
