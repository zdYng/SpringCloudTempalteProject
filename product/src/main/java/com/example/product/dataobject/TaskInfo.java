package com.example.product.dataobject;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class TaskInfo {

//    @Id
//    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Id
    private String taskId;

    /** 名称 */
    private String taskName;

    /** 任务描述 */
    @Column(columnDefinition = "text")
    private String taskDescription;

    /** 状态 0 未过期 1 已过期*/
    private Integer taskStatus = 0;

    /** 任务类型id  */
    private Integer categoryType;

    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
}
