package com.example.product.service;

import com.example.product.ProductApplication;
import com.example.product.ProductApplicationTests;
import com.example.product.dataobject.TaskInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
class TaskServiceTest extends ProductApplicationTests {
    @Autowired
    private TaskService taskService;

    @Test
    public void findUpAll() throws Exception {
        List<TaskInfo> list =  taskService.findUpAll();
        Assert.assertTrue(list.size()==0);

    }

    @Test
    public void findList2() throws Exception{
        List<TaskInfo> list = taskService.findList2(Arrays.asList("1","2"));
        Assert.assertTrue(list.size()>0);


    }

}