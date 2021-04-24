package dev.iagorodrigues.productapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iagorodrigues.productapi.model.Category;

public class CategoryDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CategoryDTO convert (Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
