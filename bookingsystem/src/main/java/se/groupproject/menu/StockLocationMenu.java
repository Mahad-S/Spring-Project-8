package se.gruppprojekt.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.gruppprojekt.entity.StockLocation;
import se.gruppprojekt.service.StockLocationService;

import java.util.List;
import java.util.Scanner;

@Component
public class StockLocationMenu {

    @Autowired
    private StockLocationService stockLocationService;

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {

        while (true) {

            System.out.println("\n--- Stock Location Menu ---");
            System.out.println("1. Show all stock locations");
            System.out.println("2. Add stock location");
            System.out.println("3. Delete stock location");
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    showAllStockLocations();
                    break;

                case 2:
                    addStockLocation();
                    break;

                case 3:
                    deleteStockLocation();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void showAllStockLocations() {

        List<StockLocation> locations = stockLocationService.getAllStockLocations();

        for (StockLocation location : locations) {
            System.out.println(location.getId() + " - " + location.getShelfName());
        }
    }

    private void addStockLocation() {

        System.out.print("Enter shelf name: ");
        String shelfName = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        StockLocation stockLocation = new StockLocation(shelfName, description);

        stockLocationService.saveStockLocation(stockLocation);

        System.out.println("Stock location added");
    }

    private void deleteStockLocation() {

        System.out.print("Enter id to delete: ");
        Long id = scanner.nextLong();

        stockLocationService.deleteStockLocation(id);

        System.out.println("Stock location deleted");
    }
}