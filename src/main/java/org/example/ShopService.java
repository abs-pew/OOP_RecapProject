package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    ProductRepo productRepo;
    OrderListRepo orderRepo = new OrderListRepo();
    public static int orderIdIndex = 0;

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
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
