package org.example.exo2;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    public void createOrder(Order order) {
        this.orderService.createOrder(order);
    }
}
