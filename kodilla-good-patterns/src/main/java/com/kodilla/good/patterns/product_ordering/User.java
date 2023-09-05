package com.kodilla.good.patterns.product_ordering;

public class User {
    private final String name;
    private final String surname;
    private final String address;
    private final String email;
    private final String phone;

    public User(String name, String surname, String address, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getAddress() {
        return this.address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String toString() {
        return "User(name=" + this.getName() + ", surname=" + this.getSurname() + ", address=" + this.getAddress() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ")";
    }
}
