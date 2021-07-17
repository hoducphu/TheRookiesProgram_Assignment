package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.entity.Category;
import com.project.ecommercewebsite.repository.CategoryRepository;
import com.project.ecommercewebsite.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categorytRepository;

    // @Autowired
    // private ModelMapper modelMapper;

    @Override
    public List<Category> getAllCategories() {
        return categorytRepository.findAll();
    }

    @Override
    public Category getCategoryById(int category_id) throws ResourceNotFoundException {
        Category category = categorytRepository.findById(category_id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + category_id));
        return category;
    }

    @Override
    public Category postCategory(Category category) {
        category.setCategory_id(0);
        return categorytRepository.save(category);
    }

    @Override
    public Category updateCategory(int category_id, Category category) throws ResourceNotFoundException {
        Category newCategory = categorytRepository.findById(category_id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + category_id));

        newCategory.setCategory_name(category.getCategory_name());
        Category updatedCategory = categorytRepository.save(newCategory);
        return updatedCategory;
    }

    @Override
    public String deleteCategory(int category_id) throws ResourceNotFoundException {
        Category category = categorytRepository.findById(category_id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + category_id));
        categorytRepository.delete(category);
        return "Category has been deleted.";
    }
}