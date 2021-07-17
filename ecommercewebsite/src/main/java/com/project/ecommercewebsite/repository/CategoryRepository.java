package com.project.ecommercewebsite.repository;

import java.util.Optional;

import com.project.ecommercewebsite.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // @Query(value = "UPDATE public.category SET category_name=':category_name'
    // WHERE category_id=:category_id returning *", nativeQuery = true)
    // Optional<Category> updateCategory(@Param("category_name") String
    // category_name);
}
