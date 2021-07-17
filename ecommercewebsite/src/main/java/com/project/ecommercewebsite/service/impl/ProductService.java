package com.project.ecommercewebsite.service.impl;

import java.util.List;

import com.project.ecommercewebsite.dto.ProductDto;
import com.project.ecommercewebsite.entity.Product;
import com.project.ecommercewebsite.repository.ProductRepository;
import com.project.ecommercewebsite.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> product = productRepository.findAll();
        return ProductDto.toDto(product);
    }

    @Override
    public ProductDto getProductById(int product_id) throws ResourceNotFoundException {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + product_id));
        return ProductDto.toDto(product);
    }

    @Override
    public ProductDto postProduct(ProductDto productDto) {
        Product product = ProductDto.toEntity(productDto);
        product.setProduct_id(0);
        return ProductDto.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(int product_id, ProductDto productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + product_id));

        product.setProduct_name(productDetails.getProduct_name());
        product.setRate(productDetails.getRate());
        product.setOrigin(productDetails.getOrigin());
        product.setColor(productDetails.getColor());
        product.setBrand(productDetails.getBrand());
        product.setQuantity(productDetails.getQuantity());
        product.setMaterial(productDetails.getMaterial());
        Product updatedProduct = productRepository.save(product);
        return ProductDto.toDto(updatedProduct);
    }

    @Override
    public String deleteProduct(int product_id) throws ResourceNotFoundException {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + product_id));
        productRepository.delete(product);
        return "Product has been deleted";
    }
}