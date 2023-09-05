package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository {
    public void createProductOrder(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate) {
    }

    public void createOrder(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate) {
        System.out.println("Creating order for " + user.getName() + " " + user.getSurname() + " about ordered " +
                product + " from " + supplier.getName() + " " + " in quantity " + quantity + "Order date: " + orderDate);
    }
}
