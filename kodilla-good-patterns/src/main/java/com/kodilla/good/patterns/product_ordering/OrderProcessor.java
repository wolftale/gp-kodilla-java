package com.kodilla.good.patterns.product_ordering;

public class OrderProcessor {
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final InformationService informationService;

    public OrderProcessor(final OrderService orderService,
                          final OrderRepository orderRepository,
                          final InformationService informationService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.informationService = informationService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(),
                orderRequest.getProduct(),
                orderRequest.getQuantity(),
                orderRequest.getOrderDate());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(),
                    orderRequest.getProduct(),
                    orderRequest.getQuantity(),
                    orderRequest.getOrderDate());

            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
