package org.example.Product;

import java.time.LocalDate;

public class Fruit extends Product{
    public Fruit(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
