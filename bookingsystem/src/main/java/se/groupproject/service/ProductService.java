package gruppproject.service;

import gruppproject.entity.Product;
import gruppproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}