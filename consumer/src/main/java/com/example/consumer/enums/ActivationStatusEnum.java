package com.example.consumer.enums;


import lombok.Getter;

/** 清单激活状态 默认 0 未激活 | 1 激活 ，激活后执行人可执行任务*/

@Getter
public enum ActivationStatusEnum {
    WAIT(0,"未激活"),
    SUCCESS(1,"已激活"),
    ;
    private Integer code;

    private String message;

    ActivationStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
