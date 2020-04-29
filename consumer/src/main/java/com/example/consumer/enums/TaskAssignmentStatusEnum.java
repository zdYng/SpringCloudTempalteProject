package com.example.consumer.enums;

import lombok.Getter;

/** 任务清单状态 ，默认为0  新创建的*/

@Getter
public enum TaskAssignmentStatusEnum {
    UNFINISHED(0,"未完成"),
    FINISHED(1,"完成"),
    CANCEL(2,"取消"),
    ;

    private Integer code;

    private String message;

    TaskAssignmentStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
