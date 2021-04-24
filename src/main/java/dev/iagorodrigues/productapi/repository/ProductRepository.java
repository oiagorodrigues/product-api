package dev.iagorodrigues.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.iagorodrigues.productapi.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p.name, p.price, p.productIdentifier, p.description "
            + "from product p "
            + "join category c on p.category.id = c.id "
            + "where c.id = :categoryId ")
    public List<Object[]> getProductsByCategory (@Param("categoryId") long categoryId);

    public List<Product> findAllByProductIdentifier(String productIdentifier);
}
