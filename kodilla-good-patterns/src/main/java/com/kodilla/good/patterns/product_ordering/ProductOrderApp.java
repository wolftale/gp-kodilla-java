package com.kodilla.good.patterns.product_ordering;

public class ProductOrderApp {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new ProductOrderService(),
                new ProductOrderRepository(), new MailService());

        orderProcessor.process(orderRequest);
        System.out.println("Transaction completed.");
    }
}
