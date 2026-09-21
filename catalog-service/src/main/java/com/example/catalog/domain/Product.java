package com.example.catalog.domain;
import jakarta.persistence.*;
@Entity @Table(name="products", indexes=@Index(name="idx_product_category",columnList="category"))
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(unique=true,nullable=false) String productCode;
 @Column(nullable=false) String name;
 String category; double price;
 protected Product(){}
 public Product(String code,String name,String category,double price){this.productCode=code;this.name=name;this.category=category;this.price=price;}
 public Long getId(){return id;} public String getProductCode(){return productCode;} public String getName(){return name;} public String getCategory(){return category;} public double getPrice(){return price;}
}
