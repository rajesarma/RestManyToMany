package com.handson.service;

import com.handson.entity.OrderEntity;
import com.handson.repository.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getProductsByCategory(String category) {
        Iterable<OrderEntity> ordersList = orderRepository.findAll();
        List<OrderEntity> orders = StreamSupport.stream(ordersList.spliterator(), false)
                .filter(o -> o.getProducts()
                            .stream()
                            .anyMatch(p -> category.equalsIgnoreCase(p.getCategory())))
                .collect(Collectors.toList());
        return orders;
    }

    public List<OrderEntity> getRecentOrders() {
        Sort sortOrder = Sort.by("orderDate").descending();
        Iterable<OrderEntity> ordersList = orderRepository.findAll(sortOrder);
        List<OrderEntity> orders = StreamSupport.stream(ordersList.spliterator(), false)
                .limit(3)
                .collect(Collectors.toList());
        return orders;
    }

}
