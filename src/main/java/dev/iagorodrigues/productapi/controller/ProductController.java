package dev.iagorodrigues.productapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import dev.iagorodrigues.productapi.services.ProductService;
import dev.iagorodrigues.productapi.dto.ProductDTO;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/products/{productCode}")
    ProductDTO getProductByProductCode(@PathVariable String productCode) {
        return productService.findByProductCode(productCode);
    }

    @GetMapping("/products/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @DeleteMapping("/products/{id}")
    // throws ProductNotFoundException
    void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }

}
