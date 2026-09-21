package com.example.catalog.repository;
import com.example.catalog.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ProductRepository extends JpaRepository<Product,Long>{List<Product> findByCategoryIgnoreCase(String category);}
