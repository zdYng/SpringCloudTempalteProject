package com.example.product.service;

import com.example.product.ProductApplicationTests;
import com.example.product.dataobject.TaskCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Component
class CategoryServiceTest extends ProductApplicationTests {
    @Autowired
    private CategoryService categoryService;

    @Test
    void findByCategoryTypeIn() throws Exception{
        List<TaskCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()==0);
    }
}