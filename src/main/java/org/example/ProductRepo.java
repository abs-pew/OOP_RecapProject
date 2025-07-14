package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    public List<Product> products;

    public ProductRepo() {
        this.products = new ArrayList<>();
    }

    public Product addProduct(Product newProduct) {
        products.add(newProduct);
        System.out.println("Added product " + newProduct.productId());
        return newProduct;
    }

    public void removeProduct(String productId) {
        for (Product product : products) {
            if (product.productId().equals(productId)) {
                products.remove(product);
                System.out.println("Removed product " + productId);
                return;
            }
        }
    }

    public Product getProduct(String productId) {
        for (Product product : products) {
            if (product.productId().equals(productId)) {
                System.out.println("Found product " + productId);
                return product;
            }
        }
        System.out.println("No product with id " + productId);
        return null;
    }

    public List<Product> getAllProducts() {
     return products;
    }
}
