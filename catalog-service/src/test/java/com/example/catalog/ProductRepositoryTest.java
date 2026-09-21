package com.example.catalog;
import com.example.catalog.domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ProductRepositoryTest {
 @Test void productModelWorks(){var p=new Product("P-1","Demo","electronics",10); assertEquals("electronics",p.getCategory());}
}
