package org.example.Product;

import java.time.LocalDate;
import java.util.Date;

public abstract class Product {
    private int id;
    private static int idCounter = 0;
    private String name;
    private String description;
    private float pricePerUnit;
    private float amount;
    private LocalDate expiryDate;

    public Product() {

    }

    public int getId() {
        return id;
    }

    public Product(String name, String description, float pricePerUnit, float amount, LocalDate expiryDate) {
        this.name = name;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.amount = amount;
        this.expiryDate = expiryDate;
        idCounter++;
        this.id = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getTotalPrice(){
        return this.getAmount() * this.getPricePerUnit();
    }
}
