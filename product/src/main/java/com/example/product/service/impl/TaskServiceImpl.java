package com.example.product.service.impl;

import com.example.product.common.DecreaseInput;
import com.example.product.common.TaskInfoOutput;
import com.example.product.dataobject.TaskInfo;
import com.example.product.enums.TaskStatusEnum;
import com.example.product.repository.TaskInfoRepository;
import com.example.product.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    /**
     * 查询所有任务列表
     */
    @Autowired
    private TaskInfoRepository taskInfoRepository;

//    @Autowired
//    public TaskInfo createTask(TaskInfo taskInfo){
//
//        return taskInfoRepository.save(taskInfo);
//    }

    @Override
    public List<TaskInfo> findUpAll() {
        return taskInfoRepository.findByTaskStatus(TaskStatusEnum.UnDone.getCode());
    }

    @Override
    public List<TaskInfo> findList2(List<String> taskIdList){

        return taskInfoRepository.findByTaskIdIn(taskIdList);
    }


    @Override
    public List<TaskInfoOutput> findList(List<String> taskIdList) {
        return null;
    }

    @Override
    public void decreaseNums(List<DecreaseInput> decreaseInputList) {

    }





}
