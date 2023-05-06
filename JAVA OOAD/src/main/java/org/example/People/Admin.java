package org.example.People;

import org.example.Coupan.Coupan;
import org.example.Product.Product;
import org.example.Product.ProductList;
import org.example.Coupan.CoupanList;

public class Admin extends User {


    public Admin(String username, String password) {
        super(username, password);
    }

    public void addProduct(Product p) {
        ProductList.products.add(p);
    }

    public void deleteProduct(Product p) {
        if (ProductList.products.contains(p) == false) {
            System.out.println("No Such product exists!");
            return;
        }
        ProductList.products.remove(p);
    }

    public void createCoupan(Coupan coupan){
        CoupanList.coupanList.add(coupan);
    }


}
