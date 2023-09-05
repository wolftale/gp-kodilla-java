package com.kodilla.good.patterns.food2door;

public class ApplicationFood2Door {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.process(orderRequest);
    }
}
