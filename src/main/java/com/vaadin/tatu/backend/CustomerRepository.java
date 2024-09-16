package com.vaadin.tatu.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.tatu.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
