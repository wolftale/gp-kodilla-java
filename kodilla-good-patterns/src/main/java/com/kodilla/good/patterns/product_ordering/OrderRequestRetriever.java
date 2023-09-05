package com.kodilla.good.patterns.product_ordering;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("John", "Smith", "London", "smith@blabla.com", "123456789");

        String productName = "Laptop";
        int quantity = 1;
        LocalDateTime orderDate = LocalDateTime.of(2023, 6, 13, 12, 0);

        return new OrderRequest(user, productName, quantity, orderDate);
    }
}
