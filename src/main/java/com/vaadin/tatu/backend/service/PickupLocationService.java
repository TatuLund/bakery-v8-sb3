package com.vaadin.tatu.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vaadin.tatu.backend.PickupLocationRepository;
import com.vaadin.tatu.backend.data.entity.PickupLocation;

@Service
public class PickupLocationService {

    private final PickupLocationRepository pickupLocationRepository;

    @Autowired
    public PickupLocationService(
            PickupLocationRepository pickupLocationRepository) {
        this.pickupLocationRepository = pickupLocationRepository;
    }

    public Page<PickupLocation> findAnyMatching(Optional<String> filter,
            Pageable pageable) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return pickupLocationRepository
                    .findByNameLikeIgnoreCase(repositoryFilter, pageable);
        } else {
            return pickupLocationRepository.findByNameLikeIgnoreCase("%",
                    pageable);
        }
    }

    public long countAnyMatching(Optional<String> filter) {
        if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            return pickupLocationRepository
                    .countByNameLikeIgnoreCase(repositoryFilter);
        } else {
            return pickupLocationRepository.countByNameLikeIgnoreCase("%");
        }
    }

    public PickupLocation getDefault() {
        return findAnyMatching(Optional.empty(), PageRequest.of(0, 1))
                .iterator().next();
    }

}
