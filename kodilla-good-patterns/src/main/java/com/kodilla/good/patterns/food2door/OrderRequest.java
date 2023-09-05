package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private String product;
    private int quantity;
    private Supplier supplier;
    private LocalDateTime orderDate;

    public OrderRequest(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.supplier = supplier;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
