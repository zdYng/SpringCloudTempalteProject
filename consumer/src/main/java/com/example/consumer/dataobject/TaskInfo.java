package com.example.consumer.dataobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TaskInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String taskId;

    /** 名称 */
    private String taskName;

    /** 任务描述 */
    @Column(columnDefinition = "text")
    private String taskDescription;

    /** 状态 0 未完成 1 已完成*/
    private Integer taskStatus;

    /** 任务类型id  */
    private Integer categoryType;

    /** 创建时间 */
    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;



}
