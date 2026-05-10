// The package this file belongs to – matches the folder structure
package com.example.demo.entity;

// Importing what we need from Jakarta and Java
import jakarta.persistence.*;
import java.util.List;

// @Entity tells Spring that this class represents a database table
@Entity

// @Table sets the name of the table in the database
@Table(name = "products")

// Pre-defined database queries that we can use later
@NamedQueries({
    // Get all products
    @NamedQuery(name = "Product.findAll",
                query = "SELECT p FROM Product p"),
    // Get a product by a specific name
    @NamedQuery(name = "Product.findByName",
                query = "SELECT p FROM Product p WHERE p.name = :name"),
    // Get products that belong to a specific category
    @NamedQuery(name = "Product.findByCategory",
                query = "SELECT p FROM Product p WHERE p.category.id = :categoryId")
})
public class Product {

    // @Id marks this as the primary key (unique id for each product)
    // @GeneratedValue means the database auto-increments the id (1, 2, 3...)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nullable = false means the field MUST have a value, cannot be empty
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    // Many products can belong to ONE category (Many-to-One)
    // @JoinColumn creates a "category_id" column in the products table
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Many products can have ONE supplier (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // One product can exist in MANY stock locations
    // and one stock location can have MANY products (Many-to-Many)
    // @JoinTable creates a middle table in the database that connects them
    @ManyToMany
    @JoinTable(
        name = "product_stocklocation",                          // name of the middle table
        joinColumns = @JoinColumn(name = "product_id"),          // column for product
        inverseJoinColumns = @JoinColumn(name = "stocklocation_id") // column for stock location
    )
    private List<StockLocation> stockLocations;

    // ───── GETTERS & SETTERS ─────
    // Getters = retrieve the value of a field
    // Setters = set/change the value of a field

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }

    public List<StockLocation> getStockLocations() { return stockLocations; }
    public void setStockLocations(List<StockLocation> stockLocations) { this.stockLocations = stockLocations; }
}