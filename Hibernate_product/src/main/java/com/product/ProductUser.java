package com.product;


import java.util.Scanner;

public class ProductUser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDao dao = new ProductDao();

        System.out.println("1. Insert Product");
        System.out.println("2. Find Product By ID");
        System.out.println("Enter your choice:");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                // Insert Product
                Product p = new Product();

                System.out.println("Enter Product ID:");
                p.setId(sc.nextInt());

                sc.nextLine(); // consume newline

                System.out.println("Enter Product Name:");
                p.setName(sc.nextLine());

                System.out.println("Enter Product Price:");
                p.setPrice(sc.nextDouble());

                String result = dao.insertProduct(p);
                System.out.println(result);
                break;

            case 2:
                // Find Product
                System.out.println("Enter Product ID to search:");
                int id = sc.nextInt();

                Product foundProduct = dao.findById(id);

                if (foundProduct != null) {
                    System.out.println("Product Found:");
                    System.out.println("ID: " + foundProduct.getId());
                    System.out.println("Name: " + foundProduct.getName());
                    System.out.println("Price: " + foundProduct.getPrice());
                } else {
                    System.out.println("Product Not Found");
                }
                break;

            default:
                System.out.println("Invalid Choice");
        }

        dao.close();
        sc.close();
    }
}
