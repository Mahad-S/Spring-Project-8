package se.groupproject.menu;

import org.springframework.stereotype.Component;
import se.groupproject.entity.Category;
import se.groupproject.service.CategoryService;

import java.util.List;
import java.util.Scanner;

@Component
public class CategoryMenu {

    private final CategoryService categoryService;
    private final Scanner sc = new Scanner(System.in);

    public CategoryMenu(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n--- Category Menu ---");
            System.out.println("1. Add category");
            System.out.println("2. Show all categories");
            System.out.println("3. Find category by name");
            System.out.println("4. Delete category");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> addCategory();

                case 2 -> showAllCategories();

                case 3 -> findCategoryByName();

                case 4 -> deleteCategory();

                case 5 -> {
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addCategory() {

        System.out.print("Category name: ");
        String name = sc.nextLine();

        Category category = new Category(name);

        categoryService.save(category);

        System.out.println("Category added.");
    }

    private void showAllCategories() {

        List<Category> categories = categoryService.getAll();

        if (categories.isEmpty()) {
            System.out.println("No categories found.");
            return;
        }

        for (Category category : categories) {
            System.out.println(category.getId() + " | " + category.getName());
        }
    }

    private void findCategoryByName() {

        System.out.print("Category name: ");
        String name = sc.nextLine();

        List<Category> categories = categoryService.findByName(name);

        if (categories.isEmpty()) {
            System.out.println("No category found.");
            return;
        }

        for (Category category : categories) {
            System.out.println(category.getId() + " | " + category.getName());
        }
    }

    private void deleteCategory() {

        System.out.print("Category ID: ");
        Long id = sc.nextLong();
        sc.nextLine();

        categoryService.delete(id);

        System.out.println("Category deleted.");
    }
}