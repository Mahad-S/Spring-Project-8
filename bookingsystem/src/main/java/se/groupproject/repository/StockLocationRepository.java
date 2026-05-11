package se.gruppprojekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.gruppprojekt.entity.StockLocation;

import java.util.Optional;

public interface StockLocationRepository extends JpaRepository<StockLocation, Long> {

    Optional<StockLocation> findByShelfName(String shelfName);
}