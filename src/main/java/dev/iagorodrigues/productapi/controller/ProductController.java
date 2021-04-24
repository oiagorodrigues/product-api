package dev.iagorodrigues.productapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

import dev.iagorodrigues.productapi.service.ProductService;
import dev.iagorodrigues.productapi.dto.ProductDTO;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/products/{productIdentifier}")
    public List<ProductDTO> getAllProductsByProductIdentifier(@PathVariable String productIdentifier) {
        return productService.findAllByProductIdentifier(productIdentifier);
    }

    @GetMapping("/products/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @DeleteMapping("/products/{id}")
    // throws ProductNotFoundException
    void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }

}
