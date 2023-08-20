package com.kodilla.good.patterns.product_ordering;

public class MailService implements InformationService {
    public MailService() {
    }

    public void sendMail(User user) {

    }

    public void inform(User user) {
        this.sendMail(user);
    }
}
