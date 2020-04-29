package com.example.clientdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class DemoController {
    @GetMapping("/")
    public String index(){
        return "spring-cloud-eureka-client";
    }

    @GetMapping("/msg")
    public String getMsg(){
        return "I am product msg!!";
    }
}

