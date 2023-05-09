package org.example.Product;

import java.util.Date;
import java.time.LocalDate;

public class MeatPrdocut extends Product {
    public MeatPrdocut(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
