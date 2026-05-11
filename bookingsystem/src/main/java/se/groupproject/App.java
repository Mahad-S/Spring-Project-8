package se.groupproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.groupproject.menu.MainMenu;
import se.groupproject.repository.SupplierRepository;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean
    public CommandLineRunner run(MainMenu mainMenu) {
        return args -> {
            mainMenu.show();
        };
    }
}