package com.project.ecommercewebsite.repository;

import java.sql.Date;
import java.util.Optional;

import com.project.ecommercewebsite.entity.Product_price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends JpaRepository<Product_price, Integer> {
    // @Query(value = "UPDATE public.product_price SET update_date=':update_date',
    // price=:price WHERE productprice_id=:productprice_id returning *", nativeQuery
    // = true)
    // Optional<Product_price> updateProductPrice(@Param("update_date") Date
    // update_date, @Param("price") Integer price);
}
