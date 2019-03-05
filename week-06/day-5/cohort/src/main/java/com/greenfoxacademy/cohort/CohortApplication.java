package com.greenfoxacademy.cohort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class CohortApplication {

    public static void main(String[] args) {
        SpringApplication.run(CohortApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

}
