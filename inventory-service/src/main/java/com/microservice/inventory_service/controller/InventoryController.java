package com.microservice.inventory_service.controller;

import com.microservice.inventory_service.Service.InventoryService;
import com.microservice.inventory_service.model.Inventory;
import com.microservice.inventory_service.model.StockCheckResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {
        return inventoryService.getInventory(productId);
    }

    // NEW API 1: list every product in stock
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    // NEW API 2: check if a quantity is available, e.g. /inventory/1001/in-stock?quantity=5
    @GetMapping("/{productId}/in-stock")
    public StockCheckResponse checkStock(@PathVariable Long productId,
                                         @RequestParam(defaultValue = "1") int quantity) {
        return inventoryService.checkStock(productId, quantity);
    }
}