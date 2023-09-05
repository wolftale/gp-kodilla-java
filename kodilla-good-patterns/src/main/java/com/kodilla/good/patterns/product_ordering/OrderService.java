package com.kodilla.good.patterns.product_ordering;

import java.time.LocalDateTime;

public interface OrderService {
    boolean order(User user, String productName, int quantity, LocalDateTime orderDate);
}
