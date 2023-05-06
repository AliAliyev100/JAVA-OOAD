package org.example.Product;

import java.time.LocalDate;

public class Sweet extends Product{
    public Sweet(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
