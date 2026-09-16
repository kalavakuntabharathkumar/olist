package com.example.orders.service;
import com.example.orders.domain.Order;
import com.example.orders.dto.OrderResponse;
import com.example.orders.repository.OrderRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class OrderService {
  private final OrderRepository repo;
  public OrderService(OrderRepository repo){this.repo=repo;}
  public OrderResponse get(Long id){return repo.findById(id).map(this::map).orElseThrow();}
  public OrderResponse getByCode(String code){return repo.findByOrderCode(code).map(this::map).orElseThrow();}
  public Page<OrderResponse> history(String customer,int page,int size){
    return repo.findByCustomerIdOrderByCreatedAtDesc(customer,PageRequest.of(page,size)).map(this::map);
  }
  public List<OrderResponse> optimizedHistory(String customer,int size){
    return repo.findHistoryOptimized(customer,PageRequest.of(0,size)).stream().map(this::map).toList();
  }
  public OrderResponse create(Order order){return map(repo.save(order));}
  private OrderResponse map(Order o){return new OrderResponse(o.getId(),o.getOrderCode(),o.getCustomerId(),o.getStatus(),o.getCreatedAt());}
}
