package com.microservice.order_service.client;

import com.microservice.order_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invevntory-service")
public interface InventoryClient {

    @GetMapping("/inventory/{productId}")
    InventoryResponse getInventory(@PathVariable Long productId);
}