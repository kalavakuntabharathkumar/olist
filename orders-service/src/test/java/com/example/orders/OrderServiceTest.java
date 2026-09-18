package com.example.orders;
import com.example.orders.domain.Order;
import com.example.orders.repository.OrderRepository;
import com.example.orders.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.Instant;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class OrderServiceTest {
 @Mock OrderRepository repo;
 @InjectMocks OrderService service;
 OrderServiceTest(){MockitoAnnotations.openMocks(this);}
 @Test void mapsOrder(){var o=new Order("O-1","C-1","DELIVERED",Instant.now()); when(repo.findByOrderCode("O-1")).thenReturn(Optional.of(o)); assertEquals("O-1",service.getByCode("O-1").orderCode());}
 @Test void missingOrderFails(){when(repo.findById(99L)).thenReturn(Optional.empty()); assertThrows(Exception.class,()->service.get(99L));}
}
