package org.example;

import java.util.*;

public class OrderMapRepo implements OrderRepo {

    public Map<String, Order> orders = new HashMap<>();

    @Override
    public Order addOrder(Order newOrder) {
        orders.put(newOrder.orderId(), newOrder);
        System.out.println("Added new Order " + newOrder.orderId());
        return newOrder;
    }

@Override
    public void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    @Override
    public Order getOrder(String OrderId) {
        return orders.get(OrderId);
    }

    @Override
    public List<Order> getAllOrders() {
   return new ArrayList<>(orders.values());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderMapRepo{");
        sb.append("orders=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}
