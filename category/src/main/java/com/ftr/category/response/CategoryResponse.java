package com.ftr.category.response;

import com.ftr.category.model.Category;
import lombok.Data;

@Data
public class CategoryResponse {

    public CategoryResponse(Category category) {
        this.name = category.getName();
    }
    private String name;
}
