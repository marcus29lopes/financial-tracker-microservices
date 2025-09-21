package com.ftr.category.service;

import com.ftr.category.DTO.CategoryDTO;
import com.ftr.category.model.Category;
import com.ftr.category.repository.CategoryRepository;
import com.ftr.category.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::new)
                .toList();
    }

    public CategoryResponse addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }
}
