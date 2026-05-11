package se.groupproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.groupproject.entity.StockLocation;

import java.util.Optional;

public interface StockLocationRepository extends JpaRepository<StockLocation, Long> {

    Optional<StockLocation> findByShelfName(String shelfName);
}