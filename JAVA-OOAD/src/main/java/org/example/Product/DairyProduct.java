package org.example.Product;

import java.time.LocalDate;
import java.util.Date;

public class DairyProduct extends Product{
    public DairyProduct(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
