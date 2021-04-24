package dev.iagorodrigues.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.iagorodrigues.productapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
