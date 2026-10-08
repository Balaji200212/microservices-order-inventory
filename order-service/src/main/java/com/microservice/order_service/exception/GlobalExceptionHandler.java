package com.microservice.order_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientStock(
            InsufficientStockException exception) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                201,
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}