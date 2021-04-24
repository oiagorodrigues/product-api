package dev.iagorodrigues.productapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.iagorodrigues.productapi.model.Product;
import dev.iagorodrigues.productapi.repository.ProductRepository;
import dev.iagorodrigues.productapi.dto.ProductDTO;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductsByCategory (Long categoryId) {
//        return productRepository.getProductsByCategory(categoryId)
//                .stream()
//                .map(ProductDTO::convert)
//                .collect(Collectors.toList());
        Product product = productRepository.getProductsByCategory(categoryId);

        return null;
    }

    public List<ProductDTO> findAllByProductIdentifier(String productIdentifier) {
        List<Product> products = productRepository.findAllByProductIdentifier(productIdentifier);

        if (products.isEmpty()) {
            return null;
        }

        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO save (ProductDTO productDTO) {
        Product product = productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

//    throws ProductNotFoundException
    public void delete (long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(productRepository::delete);
    }

}
