package com.example.consumer.repository;

import com.example.consumer.ConsumerApplicationTests;
import com.example.consumer.dataobject.TaskAssignmentDetail;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskAssignmentDetailRepositoryTest extends ConsumerApplicationTests {

    @Autowired
    private TaskAssignmentDetailRepository taskAssignmentDetailRepository;

    @Test
    public void testSave(){
        TaskAssignmentDetail taskAssignmentDetail = new TaskAssignmentDetail();

        taskAssignmentDetail.setDetailId("1111");
        taskAssignmentDetail.setTaskAssignmentId("123456");
        taskAssignmentDetail.setTaskId("1");
        taskAssignmentDetail.setTaskName("task-1");

        TaskAssignmentDetail result = taskAssignmentDetailRepository.save(taskAssignmentDetail);
        Assert.assertTrue(result!=null);

    }

}
