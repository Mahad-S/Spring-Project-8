package se.groupproject.service;

import se.groupproject.entity.Category;
import se.groupproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category save(Category category) {
        return repository.save(category);
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public List<Category> findByName(String name) {
        return repository.findByName(name);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}