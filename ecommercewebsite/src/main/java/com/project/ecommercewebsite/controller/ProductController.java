package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.ecommercewebsite.dto.ProductDto;
import com.project.ecommercewebsite.entity.Product;
import com.project.ecommercewebsite.service.IProductService;

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
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    // get all product : read
    @GetMapping("")
    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = productService.getAllProduct();
        return products;
    }

    // get product by its id : read
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int product_id) {
        ProductDto product = productService.getProductById(product_id);
        return ResponseEntity.ok().body(product);
    }

    // create new product : create
    @PostMapping("")
    public ProductDto createProduct(@Valid @RequestBody ProductDto product) {
        productService.postProduct(product);
        return product;
    }

    // update product
    @PutMapping(value = "/{product_id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("product_id") int product_id,
            @RequestBody ProductDto product) {
        ProductDto updatedProduct = productService.updateProduct(product_id, product);
        return ResponseEntity.ok().body(updatedProduct);
    }

    // delete product
    @DeleteMapping(value = "/{product_id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int product_id) {
        productService.deleteProduct(product_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
