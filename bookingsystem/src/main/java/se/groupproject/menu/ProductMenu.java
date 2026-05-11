package se.groupproject.menu;

import org.springframework.stereotype.Component;
import se.groupproject.entity.Product;
import se.groupproject.service.ProductService;

import java.util.List;
import java.util.Scanner;

@Component
public class ProductMenu {

    private final ProductService productService;
    private final Scanner sc = new Scanner(System.in);

    public ProductMenu(ProductService productService) {
        this.productService = productService;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n--- Product Menu ---");
            System.out.println("1. Add product");
            System.out.println("2. Show all products");
            System.out.println("3. Find product by name");
            System.out.println("4. Delete product");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addProduct();

                case 2 -> showAllProducts();

                case 3 -> findProductByName();

                case 4 -> deleteProduct();

                case 5 -> {
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addProduct() {

        System.out.print("Product name: ");
        String name = sc.nextLine();

        System.out.print("Product price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Product product = new Product(name, price);

        productService.save(product);

        System.out.println("Product added.");
    }

    private void showAllProducts() {

        List<Product> products = productService.getAll();

        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getId() + " | "
                    + product.getName() + " | "
                    + product.getPrice());
        }
    }

    private void findProductByName() {

        System.out.print("Product name: ");
        String name = sc.nextLine();

        List<Product> products = productService.findByName(name);

        if (products.isEmpty()) {
            System.out.println("No product found.");
            return;
        }

        for (Product product : products) {
            System.out.println(product.getId() + " | "
                    + product.getName() + " | "
                    + product.getPrice());
        }
    }

    private void deleteProduct() {

        System.out.print("Product ID: ");
        Long id = sc.nextLong();
        sc.nextLine();

        productService.delete(id);

        System.out.println("Product deleted.");
    }
}