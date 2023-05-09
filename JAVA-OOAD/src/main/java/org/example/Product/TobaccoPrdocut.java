package org.example.Product;

import java.time.LocalDate;

public class TobaccoPrdocut extends Product{
    public TobaccoPrdocut(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
