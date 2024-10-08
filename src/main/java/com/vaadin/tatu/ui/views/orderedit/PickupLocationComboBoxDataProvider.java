package com.vaadin.tatu.ui.views.orderedit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.spring.dataprovider.PageableDataProvider;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.tatu.backend.data.entity.PickupLocation;
import com.vaadin.tatu.backend.service.PickupLocationService;

/**
 * A singleton data provider which knows which products are available.
 */
@SpringComponent
public class PickupLocationComboBoxDataProvider
        extends PageableDataProvider<PickupLocation, String> {

    private final PickupLocationService pickupLocationService;

    @Autowired
    public PickupLocationComboBoxDataProvider(
            PickupLocationService pickupLocationService) {
        this.pickupLocationService = pickupLocationService;
    }

    @Override
    protected Page<PickupLocation> fetchFromBackEnd(
            Query<PickupLocation, String> query, Pageable pageable) {
        return pickupLocationService.findAnyMatching(query.getFilter(),
                pageable);
    }

    @Override
    protected int sizeInBackEnd(Query<PickupLocation, String> query) {
        return (int) pickupLocationService.countAnyMatching(query.getFilter());
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        List<QuerySortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
        return sortOrders;
    }

}
