package com.example.consumer.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class TaskInfoVO {
    @JsonProperty("id")
    private String taskId;

    @JsonProperty("name")
    private String taskName;

    @JsonProperty("description")
    private String taskDescription;

    @JsonProperty("createTime")
    private String createTime;

    @JsonProperty("updateTime")
    private String updateTime;


}
