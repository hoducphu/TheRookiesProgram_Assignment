package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.dto.ProductDto;

public interface IProductService {

    List<ProductDto> getAllProduct();

    ProductDto getProductById(int product_id);

    ProductDto postProduct(ProductDto product_id);

    ProductDto updateProduct(int product_id, ProductDto product);

    String deleteProduct(int product_id);
}
