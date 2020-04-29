package com.example.consumer.VO;

import lombok.Data;

/**
 * 数据结构
 * @param <T>
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
