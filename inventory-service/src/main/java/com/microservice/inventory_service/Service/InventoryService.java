package com.microservice.inventory_service.Service;

import com.microservice.inventory_service.Repository.InventoryRepository;
import com.microservice.inventory_service.model.Inventory;
import com.microservice.inventory_service.model.StockCheckResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventory(Long productId) {

        return inventoryRepository.findByProductId(productId);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public StockCheckResponse checkStock(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        int available = inventory == null ? 0 : inventory.getQuantity();
        return new StockCheckResponse(productId, quantity, available, available >= quantity);
    }
}