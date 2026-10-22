package com.microservice.order_service.service;
import com.microservice.order_service.client.InventoryClient;
import com.microservice.order_service.dto.InventoryResponse;
import com.microservice.order_service.dto.OrderRequest;
import com.microservice.order_service.exception.InsufficientStockException;
import com.microservice.order_service.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final InventoryClient inventoryClient;

    public OrderService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public Order createOrder(OrderRequest request) {
        InventoryResponse inventory =
                inventoryClient.getInventory(request.getProductId());
        if (inventory == null) {
            throw new RuntimeException("Product not found");
        }

        if (inventory.getQuantity() < request.getQuantity()) {
            throw new InsufficientStockException(
                    "Insufficient stock for product: " + request.getProductId()
            );        }
        Order order = new Order();
        order.setOrderId(System.currentTimeMillis());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setStatus("CREATED");
        return order;
    }

    public List<InventoryResponse> getAvailableProducts() {
        return inventoryClient.getAllInventory();
    }
}
