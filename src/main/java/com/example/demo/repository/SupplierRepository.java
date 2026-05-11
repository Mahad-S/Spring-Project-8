package se.groupproject.repository;

import se.groupproject.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
    @Query(name = "Supplier.findByName")
    List<Supplier> findByName(String name);
}
