package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate);
}
