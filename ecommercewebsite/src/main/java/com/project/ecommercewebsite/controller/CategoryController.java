package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.ecommercewebsite.entity.Category;
import com.project.ecommercewebsite.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    // get all category : read
    @GetMapping("")
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories;
    }

    // get category by its id : read
    @GetMapping("/{category_id}")
    public ResponseEntity<Category> getCategory(@PathVariable int category_id) {
        Category category = categoryService.getCategoryById(category_id);
        return ResponseEntity.ok().body(category);
    }

    // create new category : create
    @PostMapping("/new")
    public Category createCategory(@Valid @RequestBody Category category) {
        categoryService.postCategory(category);
        return category;
    }

    // update category
    @PutMapping(value = "/{category_id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("category_id") int category_id,
            @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(category_id, category);
        return ResponseEntity.ok().body(updatedCategory);
    }

    // delete category
    @DeleteMapping(value = "/{category_id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable int category_id) {
        categoryService.deleteCategory(category_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
