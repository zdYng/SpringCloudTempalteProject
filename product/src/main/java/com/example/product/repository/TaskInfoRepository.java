package com.example.product.repository;

import com.example.product.dataobject.TaskInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface TaskInfoRepository extends
        JpaRepository<TaskInfo, String>
//        JpaSpecificationExecutor<TaskInfo>,
//        Serializable
{

//    TaskInfo createTask(TaskInfo taskInfo);

    List<TaskInfo> findByTaskStatus(Integer taskStatus);

    List<TaskInfo> findByTaskIdIn(List<String> taskIdList);
}
