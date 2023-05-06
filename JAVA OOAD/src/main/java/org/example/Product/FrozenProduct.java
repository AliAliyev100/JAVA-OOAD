package org.example.Product;

import java.util.Date;

public class FrozenProduct extends Product{
    public FrozenProduct(String name, String description, float pricePerUnit, float amount, Date expiryDate) {
        super(name, description, pricePerUnit, amount, expiryDate);
    }
}
