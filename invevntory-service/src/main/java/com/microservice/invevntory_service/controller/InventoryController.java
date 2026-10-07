package com.microservice.invevntory_service.controller;

import com.microservice.invevntory_service.Service.InventoryService;
import com.microservice.invevntory_service.model.Inventory;
import org.springframework.web.bind.annotation.*;

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
}