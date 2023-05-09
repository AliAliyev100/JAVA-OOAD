package org.example;

import org.example.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private List<Product> products;

    public Cart() {
        products = new ArrayList<Product>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void deleteProduct(Product product){
        if(this.products.contains(product) == false){
            System.out.printf("%s product is not in the cart!", product.getName());
            return;
        }
        this.products.remove(product);
    }

    public float getTotalPrice(){
        float totalPrice = 0f;

        for (int i = 0; i < getProducts().size(); i++) {
            totalPrice  = totalPrice + getProducts().get(i).getTotalPrice();
        }
        return totalPrice;
    }

    public void emptyProductsList(){
        this.products.clear();
    }






}
