package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    ProductRepo productRepo;
   // OrderRepo orderRepo = new OrderListRepo();
    //OrderRepo orderRepo = new OrderMapRepo();
    OrderRepo orderRepo;
    public static int orderIdIndex = 0;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Order placeNewOder(List<String> productIds) {
        List<Product> availableProducts = new ArrayList<>();
        Product requestedProduct;
        Order currentOrder;
        for (String productId : productIds) {
            requestedProduct = productRepo.getProduct(productId);
            if ( requestedProduct == null) {
                System.out.println("Product " + productId + " is not in stock. Revisit your products list please.");
                return null;  // do not entertain incomplete order
            }
            availableProducts.add(requestedProduct);
        }
        orderIdIndex = orderIdIndex + 1;
        currentOrder = new Order("ORD" + orderIdIndex, availableProducts);
        orderRepo.addOrder(currentOrder);
        return currentOrder;
    }
}
