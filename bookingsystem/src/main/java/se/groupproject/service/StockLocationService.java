package se.groupproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.groupproject.entity.StockLocation;
import se.groupproject.repository.StockLocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockLocationService {

    @Autowired
    private StockLocationRepository stockLocationRepository;

    public StockLocation saveStockLocation(StockLocation stockLocation) {
        return stockLocationRepository.save(stockLocation);
    }

    public List<StockLocation> getAllStockLocations() {
        return stockLocationRepository.findAll();
    }

    public Optional<StockLocation> getStockLocationById(Long id) {
        return stockLocationRepository.findById(id);
    }

    public Optional<StockLocation> getStockLocationByShelfName(String shelfName) {
        return stockLocationRepository.findByShelfName(shelfName);
    }

    public void deleteStockLocation(Long id) {
        stockLocationRepository.deleteById(id);
    }
}