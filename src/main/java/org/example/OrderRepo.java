package org.example;

import java.util.List;

public interface OrderRepo {

    public Order addOrder(Order newOrder);
    public void removeOrder(String orderId);
    public Order getOrder(String OrderId);
    public List<Order> getAllOrders();

}
