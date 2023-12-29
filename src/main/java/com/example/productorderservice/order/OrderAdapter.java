package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import com.example.productorderservice.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
