package com.example.product.enums;

import lombok.Getter;

@Getter
public enum TaskStatusEnum {
    /** 枚举任务状态 */
    UnDone(0, "未完成"),
    Done(1, "已完成"),
    ;

    private Integer code;

    private String message;

    TaskStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
