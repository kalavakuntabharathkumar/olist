package com.example.orders.domain;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="orders", indexes={
  @Index(name="idx_orders_customer_status", columnList="customerId,status"),
  @Index(name="idx_orders_customer_created", columnList="customerId,createdAt")
})
public class Order {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false,unique=true) private String orderCode;
  @Column(nullable=false) private String customerId;
  @Column(nullable=false) private String status;
  @Column(nullable=false) private Instant createdAt;
  protected Order(){}
  public Order(String orderCode,String customerId,String status,Instant createdAt){this.orderCode=orderCode;this.customerId=customerId;this.status=status;this.createdAt=createdAt;}
  public Long getId(){return id;} public String getOrderCode(){return orderCode;} public String getCustomerId(){return customerId;}
  public String getStatus(){return status;} public Instant getCreatedAt(){return createdAt;}
}
