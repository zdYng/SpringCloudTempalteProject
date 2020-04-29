package com.example.configclient.controller;


import com.example.configclient.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_2")
@RefreshScope
public class FeignClientControl {
    @Autowired
    ProductClient productClient;

    @GetMapping("/getmsg")
    public String getMsg(){
        String a = productClient.getMsg();
        return a;
    }

}

