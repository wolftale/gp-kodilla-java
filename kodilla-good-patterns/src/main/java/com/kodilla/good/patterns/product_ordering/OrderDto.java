package com.kodilla.good.patterns.product_ordering;

public class OrderDto {
    public User user;
    public boolean isOrdered;

    public OrderDto(final User user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isOrdered() {
        return this.isOrdered;
    }
}
