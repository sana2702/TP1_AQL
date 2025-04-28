package TP3;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createOrder(Order order) {
        orderService.createOrder(order); // Appel du service pour créer une commande
    }
}
