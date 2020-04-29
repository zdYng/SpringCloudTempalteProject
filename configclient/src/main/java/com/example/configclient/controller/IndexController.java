package com.example.configclient.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Provider;

@RestController
@RequestMapping("/order")
@RefreshScope
public class IndexController {
    @Value("${profile}")
    private String profile;

    @RequestMapping("/profile")
    public String getProfile(){
        return profile;
    }

    // 直接使用RestTemplate 手动写入提供数据url地址
    @GetMapping("/getmsg-1")
    public String getMsg(){
        String url = "http://localhost:8081/product/msg";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);

        return result;
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/getmsg-2")
    public String getMsg2(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("hhh"); // 其中choose选择的serviceId为spring:application:name:hhh
        System.out.println("host: "+serviceInstance.getHost()+ "port: " +serviceInstance.getPort());
        String url = String.format("http://%s:%s/product/msg", serviceInstance.getHost(),serviceInstance.getPort());
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        return result;
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getmsg-3")
    public String getMsg3(){

//        ServiceInstance serviceInstance = loadBalancerClient.choose("hhh");
        String result = restTemplate.getForObject("http://hhh/product/msg",String.class);
        return result;
    }
}


