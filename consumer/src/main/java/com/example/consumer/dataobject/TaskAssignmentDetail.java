package com.example.consumer.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class TaskAssignmentDetail {
    /** 明细id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String detailId;

    /** 任务清单id */
    private String taskAssignmentId;

    /** 任务id */
    private String taskId;

    /** 任务名称 */
    private String taskName;


}
