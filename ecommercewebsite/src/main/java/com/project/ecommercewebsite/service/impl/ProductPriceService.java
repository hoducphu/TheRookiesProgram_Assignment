package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.dto.ProductPriceDto;
import com.project.ecommercewebsite.entity.Product_price;
import com.project.ecommercewebsite.repository.ProductPriceRepository;
import com.project.ecommercewebsite.service.IProductPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceService implements IProductPriceService {

    @Autowired
    private ProductPriceRepository productpriceRepository;

    @Override
    public List<ProductPriceDto> getAllProductPrice() {
        List<Product_price> productPrices = productpriceRepository.findAll();
        return ProductPriceDto.toDto(productPrices);
    }

    @Override
    public ProductPriceDto getProductPriceById(int productprice_id) throws ResourceNotFoundException {
        Product_price productPrice = productpriceRepository.findById(productprice_id).orElseThrow(
                () -> new ResourceNotFoundException("Product Price not found for this id :: " + productprice_id));
        return ProductPriceDto.toDto(productPrice);
    }

    @Override
    public ProductPriceDto postProductPrice(ProductPriceDto productPriceDto) {
        Product_price productPrice = ProductPriceDto.toEntity(productPriceDto);
        productPrice.setProductprice_id(0);
        return ProductPriceDto.toDto(productpriceRepository.save(productPrice));
    }

    @Override
    public ProductPriceDto updateProductPrice(int productprice_id, ProductPriceDto product_price)
            throws ResourceNotFoundException {
        Product_price newProductPrice = productpriceRepository.findById(productprice_id).orElseThrow(
                () -> new ResourceNotFoundException("Product Price not found for this id :: " + productprice_id));

        newProductPrice.setUpdate_date(product_price.getUpdate_date());
        newProductPrice.setPrice(product_price.getPrice());
        Product_price updateProductPrice = productpriceRepository.save(newProductPrice);
        return ProductPriceDto.toDto(updateProductPrice);
    }

    @Override
    public String deleteProductPrice(int productprice_id) throws ResourceNotFoundException {
        Product_price product_price = productpriceRepository.findById(productprice_id).orElseThrow(
                () -> new ResourceNotFoundException("Product Price not found for this id :: " + productprice_id));
        productpriceRepository.delete(product_price);
        return "Product price has been deleted";
    }
}