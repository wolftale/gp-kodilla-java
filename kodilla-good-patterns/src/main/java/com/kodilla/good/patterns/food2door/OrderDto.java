package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public class OrderDto {
    private User user;
    private Supplier supplier;
    private LocalDateTime orderDate;
    public boolean isOrdered;

    public OrderDto(User user, Supplier supplier, LocalDateTime orderDate, boolean isOrdered) {
        this.user = user;
        this.supplier = supplier;
        this.orderDate = orderDate;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
