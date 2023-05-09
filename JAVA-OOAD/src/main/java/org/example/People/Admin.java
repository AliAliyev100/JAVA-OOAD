package org.example.People;

import org.example.Coupan.Coupan;
import org.example.Product.*;
import org.example.Coupan.CoupanList;

import java.time.LocalDate;

public class Admin extends User {

    private boolean ifAdmin = true;

    public boolean isIfAdmin() {
        return ifAdmin;
    }
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addProduct(Product p) {
        ProductList.products.add(p);
    }

    public Product createProduct(int productType, String productName, String productDescription, float pricePerUnitOfProduduct, int expiryYear, int expiryMonth, int expiryDate){
        Product addedProduct = null;
        if(productType == 1){
            addedProduct = new AlcoholicBeverage(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 2){
            addedProduct = new BakeryProduct(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 3){
            addedProduct = new DairyProduct(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 4){
            addedProduct = new FrozenProduct(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 5){
            addedProduct = new Fruit(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 6){
            addedProduct = new HygieneProduct(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 7){
            addedProduct = new MeatPrdocut(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 8){
            addedProduct = new SoftDrink(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 9){
            addedProduct = new Sweet(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else if(productType == 10){
            addedProduct = new TobaccoPrdocut(productName, productDescription, pricePerUnitOfProduduct, 1, LocalDate.of(expiryYear, expiryMonth, expiryDate));
        } else {
            System.out.println("Not valid Number!");
        }
        return  addedProduct;
    }

    public void deleteProduct(Product p) {
        if (ProductList.products.contains(p) == false) {
            System.out.println("No Such product exists!");
            return;
        }
        ProductList.products.remove(p);
    }

    public void deleteProduct(int productId){

        for (int i = 0; i < ProductList.products.size(); i++) {
            Product currentProduct  = ProductList.products.get(i);
            if(currentProduct.getId() == productId){
                this.deleteProduct(currentProduct);
                return;
            }
        }
        System.out.println("No Product with given ID");
    }

    public void createCoupan(Coupan coupan){
        CoupanList.coupanList.add(coupan);
    }


}
