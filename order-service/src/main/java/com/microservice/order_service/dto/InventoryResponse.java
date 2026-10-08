package com.microservice.order_service.dto;

import lombok.Data;

@Data
public class InventoryResponse {

    private Long productId;
    private String productName;
    private int quantity;
}