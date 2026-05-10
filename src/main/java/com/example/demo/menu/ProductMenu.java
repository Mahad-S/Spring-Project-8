package com.example.demo.menu;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ProductMenu {

    @Autowired
    private ProductService productService;

    private Scanner scanner = new Scanner(System.in);

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== PRODUCT MENU ===");
            System.out.println("1. Show all products");
            System.out.println("2. Search by ID");
            System.out.println("3. Search by name");
            System.out.println("4. Add product");
            System.out.println("5. Update product");
            System.out.println("6. Delete product");
            System.out.println("7. Show low stock");
            System.out.println("0. Go back");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> showAll();
                case "2" -> searchById();
                case "3" -> searchByName();
                case "4" -> addProduct();
                case "5" -> updateProduct();
                case "6" -> deleteProduct();
                case "7" -> lowStock();
                case "0" -> running = false;
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private void showAll() {
        List<Product> products = productService.getAll();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            products.forEach(p -> System.out.println(
                p.getId() + " | " + p.getName() +
                " | " + p.getPrice() + " kr" +
                " | Quantity: " + p.getQuantity()
            ));
        }
    }

    private void searchById() {
        System.out.print("Enter product ID: ");
        Long id = Long.parseLong(scanner.nextLine());
        Optional<Product> p = productService.getById(id);
        p.ifPresentOrElse(
            prod -> System.out.println(prod),
            () -> System.out.println("No product found with ID " + id)
        );
    }

    private void searchByName() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        productService.getByName(name)
            .forEach(p -> System.out.println(p));
    }

    private void addProduct() {
        Product p = new Product();
        System.out.print("Name: ");
        p.setName(scanner.nextLine());
        System.out.print("Price: ");
        p.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.print("Quantity: ");
        p.setQuantity(Integer.parseInt(scanner.nextLine()));
        productService.create(p);
        System.out.println("Product created!");
    }

    private void updateProduct() {
        System.out.print("Enter ID of product to update: ");
        Long id = Long.parseLong(scanner.nextLine());
        productService.getById(id).ifPresentOrElse(p -> {
            System.out.print("New name (press enter to keep): ");
            String name = scanner.nextLine();
            if (!name.isBlank()) p.setName(name);
            System.out.print("New price (press enter to keep): ");
            String price = scanner.nextLine();
            if (!price.isBlank()) p.setPrice(Double.parseDouble(price));
            System.out.print("New quantity (press enter to keep): ");
            String quantity = scanner.nextLine();
            if (!quantity.isBlank()) p.setQuantity(Integer.parseInt(quantity));
            productService.update(p);
            System.out.println("Product updated!");
        }, () -> System.out.println("Product not found."));
    }

    private void deleteProduct() {
        System.out.print("Enter ID of product to delete: ");
        Long id = Long.parseLong(scanner.nextLine());
        productService.delete(id);
        System.out.println("Product deleted.");
    }

    private void lowStock() {
        System.out.print("Show products with less than: ");
        int threshold = Integer.parseInt(scanner.nextLine());
        productService.getLowStock(threshold)
            .forEach(p -> System.out.println(
                p.getName() + " – Quantity: " + p.getQuantity()
            ));
    }
}