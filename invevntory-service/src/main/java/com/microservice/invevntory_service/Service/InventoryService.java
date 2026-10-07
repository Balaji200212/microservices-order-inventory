package com.microservice.invevntory_service.Service;

import com.microservice.invevntory_service.Repository.InventoryRepository;
import com.microservice.invevntory_service.model.Inventory;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventory(Long productId) {

        return inventoryRepository.findByProductId(productId);
    }
}