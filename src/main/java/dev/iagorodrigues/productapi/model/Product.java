package dev.iagorodrigues.productapi.model;

import javax.persistence.*;

import dev.iagorodrigues.productapi.dto.ProductDTO;


@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productIdentifier;

    private String name;

    private Float price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setProductIdentifier(productDTO.getProductIdentifier());

        if (productDTO.getCategory() != null) {
            product.setCategory(Category.convert(productDTO.getCategory()));
        }

        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productIdentifier='" + productIdentifier + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
