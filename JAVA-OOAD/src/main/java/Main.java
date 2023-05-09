import org.example.Authentication;
import org.example.People.Admin;
import org.example.People.User;
import org.example.Product.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User currentuser = null;
        ProductList.products.size(); // Calls the products to load everything directly
        while(true) {
            // Checking user's initial actions - register / login / exit'
            currentuser = null;
            System.out.println("Press 1 to register\nPress 2 to login\nPress -1 to exit");
            int logReg = sc.nextInt();
            if (logReg == -1) {
                break;
            }

            while (currentuser == null) {
                System.out.println("Enter username: ");
                String username = sc.next();
                System.out.println("Enter password: ");
                String password = sc.next();
                if (logReg == 1) {
                    currentuser = Authentication.register(username, password);
                } else if (logReg == 2) {
                    currentuser = Authentication.login(username, password);
                }
                if (currentuser == null) {
                    System.out.println("Type details again! Something Went Wrong!");
                }
            }

            while (true) {
                // Checking user's actions and doing certain things depending on user input
                System.out.println("Press 1 to Add product to Cart\nPress 2 to Delete product From cart\nPress 3 to Edit Cart\nPress 4 to view Cart\nPress 5 to get Cart Total Price");
                if (currentuser.isIfAdmin()) {
                    System.out.println("Press 6 to Create new product\nPress 7 to Delete Product from Product List");
                }
                System.out.println("Press -1 to log out");
                int userAction = sc.nextInt();

                if(userAction == -1){
                    currentuser = null;
                    break;
                }

                if (userAction == 1) {
                    System.out.println("Select the product ID to Add to cart:");
                    ProductList.printProducts();
                    int selectedProductId = sc.nextInt();
                    currentuser.addToCart(selectedProductId);
                } else if (userAction == 2) {
                    System.out.println("Select the product id to remove to cart:");
                    currentuser.viewCart();
                    int selectedProductId = sc.nextInt();
                    currentuser.deleteFromCart(selectedProductId);
                } else if(userAction == 3){
                    currentuser.editCart();
                } else if(userAction == 4){
                    currentuser.viewCart();
                } else if(userAction == 5){
                    System.out.println(currentuser.getCart().getTotalPrice());
                } else if(userAction == 6){
                    currentuser = (Admin) currentuser;
                    Product addedProduct = null;
                    sc.nextLine();
                    System.out.println("Type name of Product:");
                    String productName = sc.nextLine();
                    System.out.println("Type description of Product");
                    String productDescription = sc.nextLine();

                    System.out.println("Type price per unit of Product");
                    float pricePerUnitOfProduct = sc.nextFloat();
                    System.out.println("Type expiry year, month and date pf product");
                    int expiryYear = sc.nextInt();
                    int expiryMonth = sc.nextInt();
                    int expiryDate = sc.nextInt();
                    System.out.println("Choose product Type: 1 for Alcoholic Beverage. 2 for Bakery, 3 for Dairy, 4 for Frozen, 5 for Fruit, 6 for Hygiene, 7 for Meat, 8 for Soft Drink, 9 for Sweet and 10 for Tobacco");
                    int productType = sc.nextInt();
                    addedProduct = ((Admin) currentuser).createProduct(productType, productName, productDescription, pricePerUnitOfProduct, expiryYear, expiryMonth, expiryDate);
                    ((Admin) currentuser).addProduct(addedProduct);
                } else if(userAction == 7){
                    System.out.println("Choose product ID to delete:");
                    ProductList.printProducts();
                    int productIdToDelete = sc.nextInt();
                    ((Admin) currentuser).deleteProduct(productIdToDelete);
                }
            }
        }
    }
}
