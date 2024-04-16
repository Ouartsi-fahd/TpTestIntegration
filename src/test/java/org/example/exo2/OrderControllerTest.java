package org.example.exo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Test
    void createOrder() {
        // Créer Order
        Order order = new Order("Ouartsi Fahd");

        // Créer un mock pour l'interface OrderService
        OrderService orderServiceMock = mock(OrderService.class);

        // Créer une instance de la classe OrderController en lui passant les mocks
        OrderController orderController = new OrderController(orderServiceMock);


        // Appeler la méthode createOrder de OrderController
         orderController.createOrder(order);

        // Vérifier que OrderService.createOrder est appelé avec le bon argument
        verify(orderServiceMock).createOrder(order);


        // Créer un mock pour l'interface OrderDao
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Créer une instance OrderService
        OrderService orderService = new OrderService(orderDaoMock);

        // Appeler la méthode createOrder de OrderService
        orderService.createOrder(order);

        // Vérifier que OrderDao.saveOrder est appelé avec l'objet de commande créé
        verify(orderDaoMock).saveOrder(order);


    }
}