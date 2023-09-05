package com.kodilla.good.patterns.product_ordering;

import java.time.LocalDateTime;

public class OrderRequest {
    private final User user;
    private final String productName;
    private final int quantity;
    private final LocalDateTime orderDate;

    public OrderRequest(final User user, final String productName, final int quantity, final LocalDateTime orderDate) {
        this.user = user;
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return this.user;
    }

    public String getProduct() {
        return this.productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }
}
