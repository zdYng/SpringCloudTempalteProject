package com.example.product.service;


import com.example.product.common.DecreaseInput;
import com.example.product.common.TaskInfoOutput;
import com.example.product.dataobject.TaskInfo;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    /**
     * 查询所有任务列表
     */
    List<TaskInfo> findUpAll();

    /**
     * 查询任务列表
     * @param taskIdList
     * @return
     */
    List<TaskInfo> findList2(List<String> taskIdList);

//    TaskInfo createTask(TaskInfo taskInfo);

    List<TaskInfoOutput> findList(List<String> taskIdList);

    void decreaseNums(List<DecreaseInput> decreaseInputList);


}
