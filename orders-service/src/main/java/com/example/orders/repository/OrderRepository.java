package com.example.orders.repository;
import com.example.orders.domain.Order;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.*;
public interface OrderRepository extends JpaRepository<Order,Long>{
  Optional<Order> findByOrderCode(String orderCode);
  Page<Order> findByCustomerIdOrderByCreatedAtDesc(String customerId, Pageable pageable);
  @Query("select o from Order o where o.customerId=:customerId order by o.createdAt desc")
  List<Order> findHistoryOptimized(@Param("customerId") String customerId, Pageable pageable);
}
