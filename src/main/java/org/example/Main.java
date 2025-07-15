package org.example;


import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        stockProducts(productRepo);

OrderRepo orderRepo = new OrderMapRepo();

        ShopService macShopService = new ShopService(productRepo, orderRepo);
        macShopService.placeNewOder(List.of("MAC002", "MAC004"));
        System.out.println(macShopService.orderRepo.toString());

        macShopService.placeNewOder(List.of("MAC001"));
        macShopService.placeNewOder(List.of("MAC003"));

        System.out.println(macShopService.orderRepo.toString());

    }

    private static void stockProducts(ProductRepo productRepo) {
        productRepo.addProduct(new Product("MAC001", "M1"));
        productRepo.addProduct(new Product("MAC002", "M2"));
        productRepo.addProduct(new Product("MAC003", "M3"));
        productRepo.addProduct(new Product("MAC004", "Air"));

        productRepo.products.forEach(System.out::println);
    }

}