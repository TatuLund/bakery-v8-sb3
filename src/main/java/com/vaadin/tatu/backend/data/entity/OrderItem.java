package com.vaadin.tatu.backend.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class OrderItem extends AbstractEntity {

    @ManyToOne
    @NotNull
    private Product product;
    @Min(1)
    @Max(1000)
    private int quantity = 1;
    @Size(max = 255)
    private String comment;

    public OrderItem() {
        // Empty constructor is needed by Spring Data / JPA
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
