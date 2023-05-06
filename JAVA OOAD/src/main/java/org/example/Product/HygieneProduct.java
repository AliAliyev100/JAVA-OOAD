package org.example.Product;

import java.time.LocalDate;

public class HygieneProduct extends Product{
    public HygieneProduct(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
