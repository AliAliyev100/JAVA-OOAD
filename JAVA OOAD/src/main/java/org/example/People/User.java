package org.example.People;

import org.example.Address;
import org.example.Cart;
import org.example.Coupan.Coupan;
import org.example.Product.Product;
import org.example.Order;
import org.example.PaymentMethods.CardPayment;
import org.example.Coupan.CoupanList;
import org.example.Product.ProductList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int id;
    private String fullname;
    private List<Order> orders;
    private List<Address> addresses;
    private List<CardPayment> cards;
    private Cart cart;
    private String username;
    private String password;
    private boolean asksHelp;
    private List<Order> orderHistory;

    private int coupanPercentage = 0;

    public User(String username, String password){
        addresses = new ArrayList<>();
        cards = new ArrayList<>();
        orders = new ArrayList<>();
        orderHistory = new ArrayList<>();
        cart = new Cart();
        setPassword(password);
        setFullname(username);
    }



    public void setAsksHelp(boolean asksHelp) {
        this.asksHelp = asksHelp;
    }

    public boolean getAsksHelp() {
        return asksHelp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    private void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List getOrders() {
        return orders;
    }

    public void setOrders(List orders) {
        this.orders = orders;
    }

    public List getAddresses() {
        return addresses;
    }

    public void setAddresses(List addresses) {
        this.addresses = addresses;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void askForHelp() {
        this.setAsksHelp(true);
    }

    public void addToCart(Product product) {
        this.cart.addProduct(product);
    }

    public void deleteFromCart(Product product) {
        this.cart.deleteProduct(product);
    }

    public void viewCart() {
        for (int i = 0; i < this.cart.getProducts().size(); i++) {
            Product currentProduct = this.cart.getProducts().get(i);
            System.out.printf("Product #%d" + i);
            System.out.printf("Product name: %s", currentProduct.getName());
            System.out.printf("Product amount: %f", currentProduct.getAmount());
            System.out.printf("Product description: %s", currentProduct.getDescription());
            System.out.printf("Product total price: %f", currentProduct.getTotalPrice());
        }
    }

    public void editCart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose product number to edit:");
        System.out.println();
        for (int i = 0; i < this.cart.getProducts().size(); i++) {
            Product currentProduct = this.cart.getProducts().get(i);
            System.out.printf("Product %d name: %s", i + 1, currentProduct.getName());
        }
        int editProductId = sc.nextInt();

        while (editProductId > this.cart.getProducts().size()) {
            System.out.println("Choose a valid number!");
            System.out.println("Choose product number to edit or press -1 to exit");
            editProductId = sc.nextInt();
            if (editProductId == -1) {
                return;
            }
        }
        System.out.println("Enter new amount");
        int newProductAmount = sc.nextInt();
        this.cart.getProducts().get(editProductId - 1).setAmount(newProductAmount);
    }

    public void addBankCard(CardPayment cardPayment) {
        if (cardPayment.getIfVerified() == false) {
            System.out.println("Cannot add unverified card");
            return;
        }
        this.cards.add(cardPayment);
    }

    public Order createOrder() {
        List<Product> cartProducts = this.cart.getProducts();
        Order newOrder = new Order(cartProducts);
        return newOrder;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void changeFullname(String newFullName) {
        this.setFullname(newFullName);
    }

    public void makePayment(float amount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Method: 1 - Cash, 2 - Bank card");
        int paymentMethod = sc.nextInt();
        while (paymentMethod != 1 || paymentMethod != 2) {
            System.out.println("Choose valid number");
            System.out.println("Choose Method: 1 - Cash, 2 - Bank card, 3 - Stop the process");
            if (paymentMethod == 3) {
                return;
            }
            paymentMethod = sc.nextInt();
        }

        Order newOrder = createOrder();

        if (paymentMethod == 2) {
            if (this.cards.size() == 0) {
                System.out.println("You have no Cards Available!\nDo you want to make card payment? Press 1 for yes, other for No");
                paymentMethod = sc.nextInt();
                if (paymentMethod != 1) {
                    return;
                }
            } else {
                System.out.println("Choose between your cards");
                for (int i = 0; i < this.cards.size(); i++) {
                    System.out.println("Card number #" + i + " " + this.cards.get(i).getCardNumbers());
                }
                int chosenCard = sc.nextInt();
                while((chosenCard - 1 > this.cards.size()  || (chosenCard - 1) < 0)){
                    System.out.println("Choose correct card number or press 0 to exit");
                    chosenCard = sc.nextInt();
                    if(chosenCard == 0){
                        return;
                    }
                }
                float paymentAmount = amount;
                paymentAmount = paymentAmount * (100 - coupanPercentage) / 100;
                this.cards.get(chosenCard-1).makePayment(newOrder,paymentAmount);
            }

        }

        this.orderHistory.add(newOrder);
        this.cart.emptyProductsList();
    }

    public void applyCoupan(String coupangCode){
        for (int i = 0; i < CoupanList.coupanList.size(); i++) {
            if(CoupanList.coupanList.get(i).getCode() == coupangCode){
                coupanPercentage = CoupanList.coupanList.get(i).getDiscountPercentage();
                break;
            }
        }
        System.out.println("Coupan Code is Wrong");
    }

    public List<Order> viewOrderHistory(){
        return this.getOrders();
    }

    public List<Product> searchProduct(String productName){
        List<Product> allProducts = new ArrayList<Product>();
        for (int i = 0; i < ProductList.products.size(); i++) {
            if(ProductList.products.get(i).getName().contains(productName)){
                allProducts.add(ProductList.products.get(i));
            }
        }
        return allProducts;
    }

    public Product searchProduct(int productId){
        Product product = new Product(){};
        for (int i = 0; i < ProductList.products.size(); i++) {
            if(ProductList.products.get(i).getId() == productId){
                product = ProductList.products.get(i);
                return product;
            }
        }
        System.out.println("Warning!\nNo Product Found");
        return product;
    }

    public void changePassword(String newPassword){
        this.setPassword(newPassword);
    }



}
