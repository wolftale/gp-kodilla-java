package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    private User user;
    private String product;
    private int quantity;
    private LocalDateTime orderDate;

    @Override
    public boolean order(User user, String product, int quantity, LocalDateTime orderDate) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
        return true;
    }

    @Override
    public void createOrder(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate) {
        System.out.println("Order created for " + user.getName() + " " + user.getSurname() + " for " + quantity + " " + product + " from " + supplier.getName() + " " + " on " + orderDate);
    }
}
