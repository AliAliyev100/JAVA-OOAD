package org.example.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductList {
    public static List<Product> products = new ArrayList<>(Arrays.asList(
            new TobaccoPrdocut("Tobacco", "Tobaco products", 3.78f, 1,  LocalDate.of(2023,10,2)),
            new MeatPrdocut("Meat", "Meat products", 16.5f, 1,   LocalDate.of(2023,05,13)),
            new AlcoholicBeverage("Alcoholic", "Alcoholic Beverage", 9.5f, 1,   LocalDate.of(2023,6,23)),
            new BakeryProduct("Bakery", "Bakery Product", 0.5f, 1,   LocalDate.of(2023,10,2)),
            new DairyProduct("Dairy", "Dairy Product", 4.5f, 1,  LocalDate.of(2023,07,21)),
            new FrozenProduct("Frozen", "Frozen Product", 2.5f, 1,  LocalDate.of(2025,01,01)),
            new Fruit("Fruit", "Fruit Product", 8.54f, 1,  LocalDate.of(2023,05,31)),
            new HygieneProduct("Hygiene", "Hygiene Product", 12.54f, 1, LocalDate.of(2023,8,31)),
            new SoftDrink("SoftDrink", "SoftDrink Product", 1.04f, 1,  LocalDate.of(2023,02,15)),
            new Sweet("Sweet", "Sweet Sweet Product", 10.48f, 1,  LocalDate.of(2025,05,05)
            )));

    public static void printProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            System.out.printf("Product id #%d ", currentProduct.getId());
            System.out.printf("Product name: %s ", currentProduct.getName());
            System.out.printf("Product amount: %.2f ", currentProduct.getAmount());
            System.out.printf("Product description: %s ", currentProduct.getDescription());
            System.out.printf("Product total price: %.2f", currentProduct.getTotalPrice());
            System.out.println();
        }
    }

}
