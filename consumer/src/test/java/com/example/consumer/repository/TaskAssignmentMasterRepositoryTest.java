package com.example.consumer.repository;

import com.example.consumer.ConsumerApplication;
import com.example.consumer.ConsumerApplicationTests;
import com.example.consumer.dataobject.TaskAssignmentMaster;
import com.example.consumer.enums.ActivationStatusEnum;
import com.example.consumer.enums.TaskAssignmentStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

@Component
public class TaskAssignmentMasterRepositoryTest extends ConsumerApplicationTests {

    @Autowired
    private TaskAssignmentMasterRepository taskAssignmentMasterRepository;

    @Test
    public void testSave(){
        TaskAssignmentMaster taskAssignmentMaster = new TaskAssignmentMaster();
        taskAssignmentMaster.setTaskAssignmentId("123456");
        taskAssignmentMaster.setExecutorName("小白");
        taskAssignmentMaster.setExecutorIdentityId("3333333");
        taskAssignmentMaster.setTaskAssignmentStatus(TaskAssignmentStatusEnum.UNFINISHED.getCode());
        taskAssignmentMaster.setActivationStatus(ActivationStatusEnum.WAIT.getCode());

        TaskAssignmentMaster result = taskAssignmentMasterRepository.save(taskAssignmentMaster);
        Assert.assertTrue(result != null);
    }

}