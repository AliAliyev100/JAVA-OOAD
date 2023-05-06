package org.example.Product;

import java.time.LocalDate;

public class SoftDrink extends Product{
    public SoftDrink(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
