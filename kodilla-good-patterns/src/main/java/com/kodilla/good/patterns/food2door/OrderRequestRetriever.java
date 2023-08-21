package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user;
        String product = null;
        int quantity = 0;
        Supplier supplier;
        LocalDateTime orderDate;

        Map<String, Supplier> orders = new HashMap<>();

        user = new User("John", "Smith", "00139745");
        orderDate = LocalDateTime.of(2023, 6, 10, 14, 20);

        supplier = new Supplier("ExtraFoodShop", "Sushi", 10);
        orders.put(supplier.getName(), supplier);

        supplier = new Supplier("GlutenFreeShop", "Bread", 2);
        orders.put(supplier.getName(), supplier);

        supplier = new Supplier("HealthyShop", "Herbal Tea", 5);
        orders.put(supplier.getName(), supplier);

        Supplier request = orders.get("HealthyShop");
        return new OrderRequest(user, request.getProduct(), request.getQuantity(), request, orderDate);
    }
}
