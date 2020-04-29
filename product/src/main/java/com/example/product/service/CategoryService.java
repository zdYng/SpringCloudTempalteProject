package com.example.product.service;

import com.example.product.dataobject.TaskCategory;

import java.util.List;

public interface CategoryService {
    List<TaskCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}



