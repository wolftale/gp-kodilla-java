package com.kodilla.good.patterns.product_ordering;

import java.time.LocalDateTime;

public class ProductOrderService  implements OrderService {
    private User user;
    private String productName;
    private int quantity;
    private LocalDateTime orderDate;

    @Override
    public boolean order(User user, String productName, int quantity, LocalDateTime orderDate) {
        this.user = user;
        this.productName = productName;
        this.quantity = quantity;
        this.orderDate = orderDate;
        return true;
    }
}
