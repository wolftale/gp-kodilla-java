package com.kodilla.good.patterns.food2door;

public class OrderProcessor {
    public OrderProcessor() {
    }

    public void process(OrderRequest orderRequest) {
        if (orderRequest.getSupplier().getName().equals("ExtraFoodShop")) {
            SupplierOrderProcessor orderProcessor = new OrderProcessorExtraFoodShop(new MailService(), new ProductOrderService(), new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Order processed by ExtraFoodShop");
        } else if (orderRequest.getSupplier().getName().equals("HealthyShop")) {
            SupplierOrderProcessor orderProcessor = new OrderProcessorHealthyShop(new MailService(), new ProductOrderService(), new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Order processed by HealthyShop");
        } else if (orderRequest.getSupplier().getName().equals("GlutenFreeShop")) {
            SupplierOrderProcessor orderProcessor = new OrderProcessorGlutenFreeShop(new MailService(), new ProductOrderService(), new ProductOrderRepository());
            orderProcessor.process(orderRequest);
            System.out.println("Order processed by GlutenFreeShop");
        } else {
            System.out.println("Supplier not found.");
        }
    }
}
