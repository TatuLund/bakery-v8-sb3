package com.vaadin.tatu.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.tatu.backend.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameLikeIgnoreCase(String name, Pageable page);

    int countByNameLikeIgnoreCase(String name);

}
