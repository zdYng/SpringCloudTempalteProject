package com.example.product.common;

import lombok.Data;

@Data
public class TaskInfoOutput {
    private String taskId;

    private String taskName;

    /** 个数 */
    private Integer taskNum;

    private String taskDescription;

    /** 未完成 0 ，已完成 1 */
    private Integer taskStatus;

    private Integer categoryType;

}
