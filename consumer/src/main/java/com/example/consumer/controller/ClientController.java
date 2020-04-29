package com.example.consumer.controller;

import com.example.consumer.VO.ResultVO;
import com.example.consumer.VO.TaskIdListVO;
import com.example.consumer.VO.TaskInfoVO;
import com.example.consumer.client.TaskClient;
import com.example.consumer.dataobject.TaskInfo;
import com.example.consumer.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){

//        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8082/msg";
        // restTemplate的三种方法:
        // 1
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url,String.class);
//        log.info("response={}", response);
//        return response;

        // 2
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String host = serviceInstance.getHost();
        Integer port = serviceInstance.getPort();
        String url2 = String.format("http://%s:%s",host,port) + "/msg";
        log.info("{}",url2);

        String response = restTemplate.getForObject(url2,String.class);

        // 3 需要配置 config/RestTemplateConfig 使用@LoadBalanced可在resTemplate里使用serviceid
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
//
//
        log.info("response={}", response);
        return response;

    }

    @Autowired
    private TaskClient taskClient;


    // 使用OpenFeign
    @GetMapping("/getTaskMsgFeign")
    public String getTaskMsgFeign(){

        String response = taskClient.taskMsg();
        log.info("response={}",response);
        return response;
    }

    @PostMapping("/getTaskList")
    public ResultVO<TaskInfoVO> getTaskList(@RequestBody List<String> taskIdList){
        List<TaskInfo> taskInfoList =  taskClient.listForTask(taskIdList);
        log.info("response={}",taskInfoList);

        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("success");
        resultVO.setCode(0);
        resultVO.setData(taskInfoList);
        return resultVO;
    }
}



