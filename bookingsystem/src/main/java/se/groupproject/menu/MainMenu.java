package se.groupproject.menu;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {
    private final CategoryMenu categoryMenu;
    private final ProductMenu productMenu;
    private final SupplierMenu supplierMenu;
    private final StockLocationMenu stockLocationMenu;

    private final Scanner sc = new Scanner(System.in);
    public MainMenu(CategoryMenu categoryMenu,
                    ProductMenu productMenu,
                    SupplierMenu supplierMenu,
                    StockLocationMenu stockLocationMenu) {
        this.supplierMenu = supplierMenu;
        this.categoryMenu = categoryMenu;
        this.productMenu = productMenu;
        this.stockLocationMenu = stockLocationMenu;
    }

    public void show() {

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Category");
            System.out.println("2.  Product");
            System.out.println("3. Supplier");
            System.out.println("4. Stock Location");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1 -> categoryMenu.showMenu();
                case 2 -> productMenu.showMenu();
                case 3 -> supplierMenu.showMenu();
                case 4 -> stockLocationMenu.showMenu();
                case 5 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice, try again");
            }
        }
    }
}