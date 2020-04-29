package com.example.configclient.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hhh")
@Component
public interface ProductClient {
    @GetMapping("/product/msg")
    String getMsg();

}
