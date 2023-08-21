package com.kodilla.good.patterns.food2door;

import java.time.LocalDateTime;

public class MailService implements InformationService {
    public MailService() {
    }

    public void sendMail(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate) {
    }

    public void inform(User user, String product, int quantity, Supplier supplier, LocalDateTime orderDate) {
        System.out.println("Sending mail to " + user.getName() + " " + user.getSurname() + " about ordered " + product
                + " from " + supplier.getName() + " in quantity " + quantity + " Order date: " + orderDate);
    }
}
