package com.microservice.order_service.Controller;
import com.microservice.order_service.client.InventoryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final InventoryClient inventoryClient;

    public OrderController(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @GetMapping("/check/{productId}")
    public String checkProduct(@PathVariable Long productId) {
        return inventoryClient.getInventory(productId);
    }
}