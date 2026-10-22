package com.microservice.order_service.Controller;
import com.microservice.order_service.dto.InventoryResponse;
import com.microservice.order_service.dto.OrderRequest;
import com.microservice.order_service.model.Order;
import com.microservice.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/products")
    public List<InventoryResponse> getAvailableProducts() {
        return orderService.getAvailableProducts();
    }
}