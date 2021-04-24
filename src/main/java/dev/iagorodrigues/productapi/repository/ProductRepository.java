package dev.iagorodrigues.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.iagorodrigues.productapi.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select product.name, product.price, "
            + "product.productCode, product.description "
            + "from product "
            + "join category on product.category.id = category.id "
            + "where category.id = :categoryId ")
    List<Product> getProductByCategory (@Param("categoryId") long categoryId);

    Product findByProductCode(String productCode);
}
