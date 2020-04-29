package com.example.consumer.dataobject;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class TaskAssignmentMaster {

    /** 任务分配清单 id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String taskAssignmentId;

    /** 清单执行者名字  */
    private String executorName;

    /** 执行者身份id */
    private String executorIdentityId;

    /** 任务清单状态 ，默认为0  未完成的*/
    private Integer taskAssignmentStatus;

    /** 清单激活状态 默认 0 未激活 | 1 激活 ，激活后执行人可执行任务*/
    private Integer activationStatus;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

}



