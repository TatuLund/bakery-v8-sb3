package com.vaadin.tatu.backend.data.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Product extends AbstractEntity {

    @Size(max = 255)
    private String name;

    // Real price * 100 as an int to avoid rounding errors
    @Min(0)
    @Max(100000)
    private int price;

    public Product() {
        // Empty constructor is needed by Spring Data / JPA
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
