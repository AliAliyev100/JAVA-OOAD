package org.example.Product;

import java.time.LocalDate;

public class FrozenProduct extends Product{
    public FrozenProduct(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
