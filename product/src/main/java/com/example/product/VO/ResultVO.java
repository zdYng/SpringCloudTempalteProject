package com.example.product.VO;

import lombok.Data;

/**数据结构 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;


}
