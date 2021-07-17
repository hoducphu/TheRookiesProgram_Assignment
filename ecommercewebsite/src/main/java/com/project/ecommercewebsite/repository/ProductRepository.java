package com.project.ecommercewebsite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommercewebsite.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // @Query(value = "UPDATE public.product SET product_name=':product_name',
    // rate=:rate, origin=':origin', color=':color', brand=':brand',
    // meterial='meterial' WHERE product_id=:product_id returning *", nativeQuery =
    // true)
    // Optional<Product> updateProduct(@Param("product_name") String product_name,
    // @Param("rate") Integer rate,
    // @Param("origin") String origin, @Param("color") String color, @Param("brand")
    // String brand,
    // @Param("meterial") String meterial);
}
