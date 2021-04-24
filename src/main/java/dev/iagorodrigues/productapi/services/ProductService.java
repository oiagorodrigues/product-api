package dev.iagorodrigues.productapi.services;

import dev.iagorodrigues.productapi.dto.ProductDTO;
import dev.iagorodrigues.productapi.model.Product;
import dev.iagorodrigues.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId (Long categoryId) {
        return productRepository.getProductByCategory(categoryId)
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductCode (String productCode) {
        Product product = productRepository.findByProductCode(productCode);
        return product != null ? ProductDTO.convert(product) : null;
    }

    public ProductDTO save (ProductDTO productDTO) {
        Product product = productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

//    throws ProductNotFoundException
    public void delete (long productId) {
        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(_product -> productRepository.delete(_product));
    }

}
