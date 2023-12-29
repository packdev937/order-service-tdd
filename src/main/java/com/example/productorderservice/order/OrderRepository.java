package com.example.productorderservice.order;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
class OrderRepository {

    private final Map<Long, Order> persistance = new HashMap<>();
    private Long sequence = 0L;

    public void save(final Order order) {
        order.assignId(sequence++);
        persistance.put(order.getId(), order);
    }
}
