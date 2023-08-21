package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public interface OrderService {
    boolean order(User user, String product, int quantity, LocalDateTime orderDate);

    void createOrder(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate);
}
