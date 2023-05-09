package org.example;

import org.example.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;
    private String status;

    public Order(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }
    public List<Product> getProducts() {
        return products;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotalPrice(){
        float totalPrice = 0f;

        for (int i = 0; i < getProducts().size(); i++) {
            totalPrice  = totalPrice + getProducts().get(i).getTotalPrice();
        }
        return totalPrice;
    }
}
