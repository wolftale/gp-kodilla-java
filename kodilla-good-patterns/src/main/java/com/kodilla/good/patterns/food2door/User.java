package com.kodilla.good.patterns.food2door;

public class User {
    private String name;
    private String surname;
    private String id;

    public User(final String name, final String surname, final String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "user(name=" + this.getName() + ", surname=" + this.getSurname() + ", id=" + this.getId() + ")";
    }
}
