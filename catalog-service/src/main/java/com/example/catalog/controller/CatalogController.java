package com.example.catalog.controller;
import com.example.catalog.domain.Product; import com.example.catalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/catalog")
public class CatalogController {
 private final ProductRepository repo; public CatalogController(ProductRepository repo){this.repo=repo;}
 @GetMapping("/products") public List<Product> all(){return repo.findAll();}
 @GetMapping("/products/{id}") public Product one(@PathVariable Long id){return repo.findById(id).orElseThrow();}
 @GetMapping("/categories/{category}") public List<Product> category(@PathVariable String category){return repo.findByCategoryIgnoreCase(category);}
 @PostMapping("/products") public Product create(@RequestBody Product p){return repo.save(p);}
}
