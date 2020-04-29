package com.example.product.service.impl;

import com.example.product.dataobject.TaskCategory;
import com.example.product.repository.TaskCategoryRepository;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    @Override
    public List<TaskCategory> findByCategoryTypeIn(List<Integer> categoryTypeList){
        return taskCategoryRepository.findByCategoryTypeIn(categoryTypeList);

    }


}
