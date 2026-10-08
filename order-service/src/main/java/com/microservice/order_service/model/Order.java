package com.microservice.order_service.model;

import lombok.Data;

@Data
public class Order {

    private Long orderId;
    private Long productId;
    private int quantity;
    private String status;
}