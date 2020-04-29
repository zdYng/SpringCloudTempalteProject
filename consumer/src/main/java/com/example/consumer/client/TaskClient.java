package com.example.consumer.client;

import com.example.consumer.dataobject.TaskInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


// 声明式REST客户端（伪RPC）
// 采用了基于接口的注解 ，也是基于Ribbon作为负载均衡（轮训或者随机，可通过官网进行配置）
@FeignClient(name = "PRODUCT")
public interface TaskClient {

    @GetMapping("/msg")
    String taskMsg();


    // PostMapping中需要加上task
    @PostMapping("/task/listForTask")
    List<TaskInfo> listForTask(@RequestBody List<String> taskIdList);

}
