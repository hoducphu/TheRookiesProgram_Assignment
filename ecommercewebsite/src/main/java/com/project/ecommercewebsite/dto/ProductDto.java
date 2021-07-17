package com.project.ecommercewebsite.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.project.ecommercewebsite.entity.Product;

import lombok.Data;

@Data
public class ProductDto {
    private int product_id;

    private String product_name;

    private float rate;

    private String origin;

    private String color;

    private String brand;

    private int quantity;

    private String material;

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getProduct_id());
        productDto.setProduct_name(product.getProduct_name());
        productDto.setRate(product.getRate());
        productDto.setOrigin(product.getOrigin());
        productDto.setColor(product.getColor());
        productDto.setBrand(product.getBrand());
        productDto.setQuantity(product.getQuantity());
        productDto.setMaterial(product.getMaterial());
        return productDto;
    }

    public static List<ProductDto> toDto(List<Product> product) {
        return product.stream().map(x -> toDto(x)).collect(Collectors.toList());
    }

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProduct_id(productDto.getProduct_id());
        product.setProduct_name(productDto.getProduct_name());
        product.setRate(productDto.getRate());
        product.setOrigin(productDto.getOrigin());
        product.setColor(productDto.getColor());
        product.setBrand(productDto.getBrand());
        product.setQuantity(productDto.getQuantity());
        product.setMaterial(productDto.getMaterial());
        return product;
    }

    public static List<Product> toEntity(List<ProductDto> productDto) {
        return productDto.stream().map(x -> toEntity(x)).collect(Collectors.toList());
    }

}
