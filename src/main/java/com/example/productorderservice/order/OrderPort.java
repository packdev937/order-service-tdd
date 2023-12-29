package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
public interface OrderPort {

    Product getProductById(Long productId);

    void save(Order order);
}
