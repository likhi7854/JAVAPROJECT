import serviceimpl.ProductServiceImpl;
import sevices.ProductServices;

import java.util.Scanner;
import static  menus.ProductMenu.productMenu;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductServices productService = new ProductServiceImpl();


        while (true) {

            System.out.println("\n================================");
            System.out.println(" ||   E-COMMERCE MANAGEMENT SYSTEM ||");
            System.out.println("================================");

            System.out.println("1. Product Management");


            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    productMenu(sc,productService);
                    break;
                case 2:
                    System.out.println("still need to update ");
                    break;
                default:
                    System.out.println("invalid choice ");

            }

        }
    }
    }
