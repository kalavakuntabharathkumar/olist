package com.example.orders.controller;
import com.example.orders.domain.Order;
import com.example.orders.dto.OrderResponse;
import com.example.orders.service.OrderService;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/orders")
public class OrderController {
  private final OrderService service;
  public OrderController(OrderService service){this.service=service;}
  @GetMapping("/{id}") public OrderResponse get(@PathVariable Long id){return service.get(id);}
  @GetMapping("/code/{code}") public OrderResponse getByCode(@PathVariable String code){return service.getByCode(code);}
  @GetMapping("/customer/{customerId}") public Object history(@PathVariable String customerId,@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size){return service.history(customerId,page,size);}
  @GetMapping("/customer/{customerId}/optimized") public List<OrderResponse> optimized(@PathVariable String customerId,@RequestParam(defaultValue="20") int size){return service.optimizedHistory(customerId,size);}
  @PostMapping @PreAuthorize("hasRole('ADMIN')") public ResponseEntity<OrderResponse> create(@RequestBody Order order){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(order));}
}
