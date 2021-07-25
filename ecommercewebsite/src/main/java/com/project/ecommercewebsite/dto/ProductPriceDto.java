package com.project.ecommercewebsite.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.ecommercewebsite.entity.Product_price;

import lombok.Data;

@Data
public class ProductPriceDto {
    private int productprice_id;

    private Date update_date;

    private int price;

    public static ProductPriceDto toDto(Product_price productPrice) {
        ProductPriceDto productPriceDto = new ProductPriceDto();
        productPriceDto.setProductprice_id(productPrice.getProductprice_id());
        productPriceDto.setUpdate_date(productPrice.getUpdate_date());
        productPriceDto.setPrice(productPrice.getPrice());
        return productPriceDto;
    }

    public static List<ProductPriceDto> toDto(List<Product_price> orders) {
        return orders.stream().map(x -> toDto(x)).collect(Collectors.toList());
    }

    public static Product_price toEntity(ProductPriceDto productPriceDto) {
        Product_price productPrice = new Product_price();
        productPrice.setProductprice_id(productPriceDto.getProductprice_id());
        productPrice.setUpdate_date(productPriceDto.getUpdate_date());
        productPrice.setPrice(productPriceDto.getPrice());
        return productPrice;
    }

    public static List<Product_price> toEntity(List<ProductPriceDto> productPriceDto) {
        return productPriceDto.stream().map(x -> toEntity(x)).collect(Collectors.toList());
    }
}
