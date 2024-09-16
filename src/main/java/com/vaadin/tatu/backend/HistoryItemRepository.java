package com.vaadin.tatu.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.tatu.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
