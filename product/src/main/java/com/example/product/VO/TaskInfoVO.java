package com.example.product.VO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaskInfoVO {

    @JsonProperty("id")
    private String taskId;

    @JsonProperty("name")
    private String taskName;

    @JsonProperty("description")
    private String taskDescription;


}



