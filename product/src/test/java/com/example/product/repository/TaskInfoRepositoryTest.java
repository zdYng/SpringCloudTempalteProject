package com.example.product.repository;

import com.example.product.dataobject.TaskInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskInfoRepositoryTest {

    @Autowired
    private TaskInfoRepository taskInfoRepository;

    @Test
    public void findByTaskStatus() throws Exception{
        List<TaskInfo> list =   taskInfoRepository.findByTaskStatus(0);
        System.out.println(list);

    }

    @Test
    public void findByTaskIdIn() throws Exception{
        List<TaskInfo> list = taskInfoRepository.findByTaskIdIn(Arrays.asList("1","2"));
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void createTask() throws Exception{
        TaskInfo taskInfo = new TaskInfo();

        taskInfo.setCategoryType(1);
        taskInfo.setTaskDescription("任务描述：测试用例6");
        taskInfo.setTaskName("测试任务-"+(int)(1+Math.random()*100));
        taskInfo.setTaskId("66666");

        TaskInfo result = taskInfoRepository.save(taskInfo);
        Assert.assertTrue(result!=null);

    }
}
