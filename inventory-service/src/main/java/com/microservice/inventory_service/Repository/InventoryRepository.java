package com.microservice.inventory_service.Repository;

import com.microservice.inventory_service.model.Inventory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryRepository {

    private final List<Inventory> inventories = new ArrayList<>();

    public InventoryRepository() {
        inventories.add(new Inventory(1001L, "Laptop", 10));
        inventories.add(new Inventory(1002L, "Phone", 25));
        inventories.add(new Inventory(1003L, "Mouse", 50));
    }

    public Inventory findByProductId(Long productId) {
        return inventories.stream()
                .filter(inventory -> inventory.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public List<Inventory> findAll() {
        return List.copyOf(inventories);
    }
}