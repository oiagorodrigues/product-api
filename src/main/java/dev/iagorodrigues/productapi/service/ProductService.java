package dev.iagorodrigues.productapi.service;

import java.util.ArrayList;
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

    public List<ProductDTO> getProductsByCategory (Long categoryId) {
        List<ProductDTO> productDTOList = new ArrayList<>();

        productRepository.getProductsByCategory(categoryId)
                .forEach(item -> {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setName(item[0].toString());
                    productDTO.setPrice(Float.parseFloat(item[1].toString()));
                    productDTO.setProductIdentifier(item[2].toString());
                    productDTO.setDescription(item[3].toString());
                    productDTOList.add(productDTO);
                });

        return productDTOList;
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
