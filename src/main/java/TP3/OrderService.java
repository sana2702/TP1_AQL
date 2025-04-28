package TP3;

public class OrderService {
    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        orderDao.saveOrder(order); // Appel du DAO pour enregistrer la commande
    }
}

