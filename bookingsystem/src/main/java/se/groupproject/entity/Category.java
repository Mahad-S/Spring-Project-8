package se.groupproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(
        name = "Category.findByName",
        query = "SELECT c FROM Category c WHERE c.name = :name"
)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}