package com.example.product.common;

import lombok.Data;

@Data
public class DecreaseInput {
    private String taskId;

    /** 任务数量 */
    private Integer taskQuantity;

    public DecreaseInput(String taskId, Integer taskQuantity){
        this.taskId = taskId;
        this.taskQuantity = taskQuantity;

    }

}
