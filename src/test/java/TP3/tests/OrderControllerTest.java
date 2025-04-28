package TP3.tests;

import static org.mockito.Mockito.*;

import TP3.Order;
import TP3.OrderController;
import TP3.OrderDao;
import TP3.OrderService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Création du mock de OrderDao
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Création du mock de OrderService
        OrderService orderServiceMock = mock(OrderService.class);

        // Création de l'instance de OrderController avec le mock de OrderService
        OrderController orderController = new OrderController(orderServiceMock);

        // Création d'une commande à tester
        Order order = new Order("Laptop", 1);

        // Appel de la méthode createOrder() sur le controller
        orderController.createOrder(order);

        // Vérification que la méthode createOrder() a bien été appelée sur le mock de OrderService avec le bon argument
        verify(orderServiceMock).createOrder(order);

        // Nous devons vérifier aussi que saveOrder() a été appelé sur le mock de OrderDao
        verify(orderDaoMock).saveOrder(order);
    }
}
