import serviceimpl.ProductServiceImpl;
import sevices.ProductServices;

import java.util.Scanner;

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

            }

        }
    }
    }
