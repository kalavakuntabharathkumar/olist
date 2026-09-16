package com.example.orders.dto;
import java.time.Instant;
public record OrderResponse(Long id,String orderCode,String customerId,String status,Instant createdAt){}
