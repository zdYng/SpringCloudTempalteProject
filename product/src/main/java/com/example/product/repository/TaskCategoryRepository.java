package com.example.product.repository;


import com.example.product.dataobject.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;


/**
 * JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、
 * Serializable（序列化接口）
 */

public interface TaskCategoryRepository extends
        JpaRepository<TaskCategory, Integer>
//        JpaSpecificationExecutor<TaskCategory>,
//        Serializable
{
    List<TaskCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}


