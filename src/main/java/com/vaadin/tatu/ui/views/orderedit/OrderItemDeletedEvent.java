package com.vaadin.tatu.ui.views.orderedit;

import com.vaadin.tatu.backend.data.entity.OrderItem;

public class OrderItemDeletedEvent {

    private OrderItem orderItem;

    public OrderItemDeletedEvent(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }
}
