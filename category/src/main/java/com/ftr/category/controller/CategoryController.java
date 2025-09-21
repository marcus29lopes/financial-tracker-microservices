package com.ftr.category.controller;

import com.ftr.category.response.CategoryResponse;
import com.ftr.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/categories")
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
