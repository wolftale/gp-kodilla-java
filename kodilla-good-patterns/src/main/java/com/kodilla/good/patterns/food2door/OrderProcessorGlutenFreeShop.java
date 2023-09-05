package com.kodilla.good.patterns.food2door;

public class OrderProcessorGlutenFreeShop implements SupplierOrderProcessor {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessorGlutenFreeShop(final InformationService informationService,
                                        final OrderService orderService,
                                        final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(),
                orderRequest.getProduct(),
                orderRequest.getQuantity(),
                orderRequest.getOrderDate());

        if (isOrdered) {
            System.out.println("Order from " + orderRequest.getUser().getName() + " has been placed.");
            informationService.inform(orderRequest.getUser(), orderRequest.getProduct(),
                    orderRequest.getQuantity(), orderRequest.getSupplier(), orderRequest.getOrderDate());

            return new OrderDto(orderRequest.getUser(), orderRequest.getSupplier(), orderRequest.getOrderDate(), isOrdered);
        } else {
            System.out.println("Order from " + orderRequest.getUser().getName() + " has not been placed.");
            return new OrderDto(orderRequest.getUser(), orderRequest.getSupplier(), orderRequest.getOrderDate(), isOrdered);
        }
    }
}
