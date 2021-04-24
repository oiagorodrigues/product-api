package dev.iagorodrigues.productapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iagorodrigues.productapi.model.Product;

public class ProductDTO {

    @NotBlank
    private String productCode;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Float price;

    @NotNull
    private CategoryDTO categoryDTO;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public static ProductDTO convert (Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setProductCode(product.getProductCode());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());

        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
        }

        return productDTO;
    }

}
