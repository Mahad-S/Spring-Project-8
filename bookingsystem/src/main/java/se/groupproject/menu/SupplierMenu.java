package se.groupproject.menu;

import se.groupproject.entity.Supplier;
import se.groupproject.service.StockLocationService;
import se.groupproject.service.SupplierService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class SupplierMenu {
    private final SupplierService supplierService;

    public SupplierMenu(SupplierService supplierService, StockLocationService stockLocationService) {


        this.supplierService = supplierService;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSupplier Menu");
            System.out.println("1. Add supplier");
            System.out.println("2. View all suppliers");
            System.out.println("3. Find supplier by name");
            System.out.println("4. Update supplier");
            System.out.println("5. Delete supplier");
            System.out.println("6. Back");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    Supplier supplier = new Supplier(name, email, phone);

                    supplierService.createSupplier(supplier);

                    System.out.println("Supplier added.");
                }
                case 2 -> {
                    List<Supplier> suppliers = supplierService.getAllSuppliers();
                    suppliers.forEach(s -> System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail()));
                }
                case 3 -> {
                    System.out.print("Supplier name: ");
                    String name = sc.nextLine();

                    List<Supplier> suppliers = supplierService.getSupplierByName(name);

                    suppliers.forEach(s ->
                            System.out.println(s.getId() + " | " + s.getName()));
                }
                case 4 -> {
                    System.out.print("Supplier ID: ");
                    Long id = sc.nextLong();
                    sc.nextLine();

                    var optionalSupplier = supplierService.getSupplierById(id);

                    if (optionalSupplier.isPresent()) {

                        Supplier supplier = optionalSupplier.get();

                        System.out.print("New name: ");
                        supplier.setName(sc.nextLine());

                        System.out.print("New email: ");
                        supplier.setEmail(sc.nextLine());

                        System.out.print("New phone: ");
                        supplier.setPhone(sc.nextLine());

                        supplierService.updateSupplier(supplier);

                        System.out.println("Supplier updated.");

                    } else {
                        System.out.println("Supplier not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Supplier ID: ");
                    Long id = sc.nextLong();
                    supplierService.deleteSupplier(id);
                    System.out.println("Supplier deleted.");
                }
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
