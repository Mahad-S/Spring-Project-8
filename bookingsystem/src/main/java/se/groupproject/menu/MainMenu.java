package se.groupproject.menu;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {
    private final SupplierMenu supplierMenu;

    private final Scanner sc = new Scanner(System.in);
    public MainMenu(SupplierMenu supplierMenu) {
        this.supplierMenu = supplierMenu;
    }

    public void show() {

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("3. Category");
            System.out.println("2.  Product");
            System.out.println("1. Supplier");
            System.out.println("4. Stock Location");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1 -> supplierMenu.showMenu();
                case 2 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice, try again");
            }
        }
    }
}