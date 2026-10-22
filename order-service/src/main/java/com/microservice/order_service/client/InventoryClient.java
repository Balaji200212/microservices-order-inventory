package com.microservice.order_service.client;

import com.microservice.order_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    InventoryResponse getInventory(@PathVariable Long productId);

    @GetMapping("/inventory")
    List<InventoryResponse> getAllInventory();
}