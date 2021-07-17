package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.entity.Category;

public interface ICategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(int category_id);

    Category postCategory(Category category);

    Category updateCategory(int category_id, Category category);

    String deleteCategory(int category_id);
}
