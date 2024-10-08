package com.vaadin.tatu.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.tatu.backend.data.entity.PickupLocation;

public interface PickupLocationRepository
        extends JpaRepository<PickupLocation, Long> {

    Page<PickupLocation> findByNameLikeIgnoreCase(String nameFilter,
            Pageable pageable);

    int countByNameLikeIgnoreCase(String nameFilter);
}
