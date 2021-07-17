package com.project.ecommercewebsite.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.project.ecommercewebsite.dto.ProductPriceDto;
import com.project.ecommercewebsite.entity.Product_price;
import com.project.ecommercewebsite.service.IProductPriceService;

@RestController
@RequestMapping("/api/productprice")
public class ProductPriceController {

    @Autowired
    private IProductPriceService productpriceService;

    // get all product price : read
    @GetMapping("")
    public List<ProductPriceDto> getAllProductPrice() {
        List<ProductPriceDto> product_prices = productpriceService.getAllProductPrice();
        return product_prices;
    }

    // get produce price by its id : read
    @GetMapping("/{productprice_id}")
    public ResponseEntity<ProductPriceDto> getProductPrice(@PathVariable int productprice_id) {
        ProductPriceDto product_price = productpriceService.getProductPriceById(productprice_id);
        return ResponseEntity.ok().body(product_price);
    }

    // create new product price : create
    @PostMapping("")
    public ProductPriceDto createProductPrice(@Valid @RequestBody ProductPriceDto productPrice) {
        productpriceService.postProductPrice(productPrice);
        return productPrice;
    }

    // update product price
    @PutMapping(value = "/{productprice_id}")
    public ResponseEntity<ProductPriceDto> updateProductPrice(@PathVariable("productprice_id") int productprice_id,
            @RequestBody ProductPriceDto product_price) {
        ProductPriceDto updatedProductPrice = productpriceService.updateProductPrice(productprice_id, product_price);
        return ResponseEntity.ok().body(updatedProductPrice);
    }

    // delete product price
    @DeleteMapping(value = "/{productprice_id}")
    public ResponseEntity<Product_price> deleteProductPrice(@PathVariable int productprice_id) {
        productpriceService.deleteProductPrice(productprice_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}