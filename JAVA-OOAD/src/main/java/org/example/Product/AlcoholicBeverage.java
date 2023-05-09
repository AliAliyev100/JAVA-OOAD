package org.example.Product;

import java.time.LocalDate;

public class AlcoholicBeverage extends Product {
    public AlcoholicBeverage(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
