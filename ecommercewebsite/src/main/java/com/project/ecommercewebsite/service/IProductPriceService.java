package com.project.ecommercewebsite.service;

import java.util.List;

import com.project.ecommercewebsite.dto.ProductPriceDto;

public interface IProductPriceService {

    List<ProductPriceDto> getAllProductPrice();

    ProductPriceDto getProductPriceById(int productprice_id);

    ProductPriceDto postProductPrice(ProductPriceDto productPriceDto);

    ProductPriceDto updateProductPrice(int productprice_id, ProductPriceDto productPriceDto);

    String deleteProductPrice(int productprice_id);
}
