package com.kodilla.good.patterns.product_ordering;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(User user, String productName, int quantity, LocalDateTime orderDate);
}
