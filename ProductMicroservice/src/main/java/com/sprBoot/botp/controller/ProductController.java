package com.sprBoot.botp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprBoot.botp.exception.ProductNotFoundException;
import com.sprBoot.botp.model.CustomResponse;
import com.sprBoot.botp.model.Product;
import com.sprBoot.botp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create Product
    @PostMapping
    public ResponseEntity<CustomResponse> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        CustomResponse response = new CustomResponse("New product added", createdProduct);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All Products
    @GetMapping
    public ResponseEntity<CustomResponse> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        CustomResponse response = new CustomResponse("All products fetched", products);
        return ResponseEntity.ok(response);
    }

    // Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id);
            CustomResponse response = new CustomResponse("Requested product is fetched", product);
            return ResponseEntity.ok(response);
        } catch (ProductNotFoundException ex) {
            CustomResponse response = new CustomResponse(ex.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Update Product
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        CustomResponse response = new CustomResponse("Product updated successfully", updatedProduct);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            CustomResponse response = new CustomResponse("Product is deleted", id);
            return ResponseEntity.ok(response);
        } catch (ProductNotFoundException ex) {
            CustomResponse response = new CustomResponse(ex.getMessage(), id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}