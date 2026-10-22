package Menus;

import model.Product;
import sevices.ProductServices;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {
       public static void productMenu(Scanner sc,ProductServices productServices) {
           while (true) {

               System.out.println("\n================================");
               System.out.println("      Product MANAGEMENT");
               System.out.println("================================");

               System.out.println("1. Add Product");
               System.out.println("2. View Products");
               System.out.println("3. Update Product");
               System.out.println("4. Delete Product");
               System.out.println("5. Back");

               System.out.print("Enter your choice: ");
               int choice;

               try {
                   choice = sc.nextInt();
                   sc.nextLine();
               } catch (Exception e) {
                   System.out.println("Please enter a number.");
                   sc.nextLine();
                   continue;
               }

               switch (choice) {
                   case 1:
                       System.out.println("Enter the product_name :");
                       String product_name = sc.nextLine();
                       System.out.println("Enter the description of that product :");
                       String description = sc.nextLine();
                       System.out.println("Enter the Price :");
                       double price;
                       try {
                           price = sc.nextDouble();
                           sc.nextLine();

                           if (price <= 0) {
                               System.out.println("Price must be greater than 0.");
                               break;
                           }

                       } catch (InputMismatchException e) {
                           System.out.println("Please enter a valid price .");
                           System.out.println("InputMismatchException");
                           sc.nextLine();
                           break;
                       }
                       System.out.println("Enter the Stock Quantity :");
                       int stock_Quantity;
                       try {
                           stock_Quantity = sc.nextInt();
                           sc.nextLine();
                           if (stock_Quantity < 0) {
                               System.out.println("Out of stock have to add more ");
                           }
                       } catch (Exception e) {
                           System.out.println("Please enter a valid price .");
                           sc.nextLine();
                           break;
                       }
                       System.out.println("Enter the status of the product :");
                       String status = "";

                       while (true) {
                           System.out.println("Select product status:");
                           System.out.println("1. ACTIVE");
                           System.out.println("2. INACTIVE");
                           System.out.print("Enter your choice: ");

                           int statusChoice;

                           try {
                               statusChoice = sc.nextInt();
                               sc.nextLine();
                           } catch (InputMismatchException e) {
                               System.out.println("Please enter 1 or 2.");
                               sc.nextLine();
                               continue;
                           }

                           if (statusChoice == 1) {
                               status = "ACTIVE";
                               break;
                           } else if (statusChoice == 2) {
                               status = "INACTIVE";
                               break;
                           } else {
                               System.out.println("Invalid choice. Please select 1 or 2.");
                           }
                           System.out.println(status);

                       }
                       Product p = new Product(product_name, description, price, stock_Quantity, status);
                       productServices.addProduct(p);

                       break;
                   case 2:

                       List<Product> products = productServices.getAllProduct();
                       if (products.isEmpty()) {
                           System.out.println("No product found.");
                       } else {
                           for (Product product : products) {
                               System.out.println("Product id           :" + product.getProduct_id());
                               System.out.println("Product name         :" + product.getProduct_name());
                               System.out.println("Product Description  :" + product.getDescription());
                               System.out.println("Product Price        :" + product.getPrice());
                               System.out.println("Stock Quantity       :" + product.getStock_quantity());
                               System.out.println("Product status       :" + product.getStatus());
                           }
                       }

                       break;

                   case 3:
                       System.out.println("Enter the product_id :");
                       int id = sc.nextInt();
                       System.out.println("Enter the product_name :");
                       String name = sc.nextLine();
                       System.out.println("Enter the description of that product :");
                       String des = sc.nextLine();
                       System.out.println("Enter the Price :");
                       double product_price = sc.nextDouble();
                       System.out.println("Enter the Stock Quantity :");
                       int stock = sc.nextInt();
                       sc.nextLine();
                       System.out.println("Enter the status of the product :");
                       String product_status= sc.nextLine();
                       Product updateProduct= new Product(name,des,product_price,stock,product_status);
                       updateProduct.setProduct_id(id);
                       productServices.updateProducts(updateProduct);
                       break;







               }





           }
       }

}
