package com.example.product.controller;


import com.example.product.VO.ResultVO;
import com.example.product.VO.TaskInfoVO;
import com.example.product.VO.TaskVO;
import com.example.product.dataobject.TaskCategory;
import com.example.product.dataobject.TaskInfo;
import com.example.product.service.CategoryService;
import com.example.product.service.TaskService;
import com.example.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<TaskVO> list(){

        /** 查询所有任务列表  */
        List<TaskInfo> taskInfoList = taskService.findUpAll();

        /** 获取任务类型列表 */
        List<Integer> categoryTypeList = taskInfoList.stream()
                .map(TaskInfo::getCategoryType)
                .collect(Collectors.toList());

        /**  从数据库查询类目 */
        List<TaskCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        System.out.println("categoryList: "+categoryList);
        /** 构造返回数据结构 */
        List<TaskVO> taskVOList = new ArrayList<>();
        for (TaskCategory taskCategory: categoryList){
            TaskVO taskVO = new TaskVO();
            taskVO.setCategoryName(taskCategory.getCategoryName());
            taskVO.setCategoryType(taskCategory.getCategoryType());

            List<TaskInfoVO> taskInfoVOList = new ArrayList<>();
            for (TaskInfo taskInfo:taskInfoList){
                if (taskInfo.getCategoryType().equals(taskCategory.getCategoryType())){
                    TaskInfoVO taskInfoVO = new TaskInfoVO();
                    BeanUtils.copyProperties(taskInfo, taskInfoVO);  // 拷贝内容
                    taskInfoVOList.add(taskInfoVO);
                }
            }
            taskVO.setTaskInfoVOList(taskInfoVOList);
            taskVOList.add(taskVO);
        }
//        ResultVO resultVO = new ResultVO();
//        resultVO.setData(taskVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");

        return ResultVOUtil.sucess(taskVOList);
    }

    /**
     * 获取任务列表（给任务清单服务使用）
     * @param taskIdList
     * @return
     */
    @PostMapping("/listForTask")
    public List<TaskInfo> listForTask(@RequestBody List<String> taskIdList){

        return taskService.findList2(taskIdList);
    }

//    @PostMapping("/createTask")
//    public TaskInfo createTask(@RequestBody TaskInfo taskInfo){
//
//        return taskService.createTask(taskInfo);
//    }

}
