package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
    public List<Order> orders;


    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    public Order addOrder(Order newOrder) {
        orders.add(newOrder);
        System.out.println("Added new Order " + newOrder.orderId());
        return newOrder;
    }

    public void removeOrder(String orderId) {
        for (Order Order : orders) {
            if (Order.orderId().equals(orderId)) {
                orders.remove(Order);
                System.out.println("Removed Order " + orderId);
              return;
            }
        }
    }

    public Order getOrder(String OrderId) {
        for (Order Order : orders) {
            if (Order.orderId().equals(OrderId)) {
                System.out.println("Found Order " + OrderId);
                return Order;
            }
        }
        System.out.println("No Order with id " + OrderId);
        return null;
    }

    public List<Order> getAllOrders() {
     return orders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderListRepo{");
        sb.append("orders=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}
