package com.handson.controller;

import com.handson.entity.OrderEntity;
import com.handson.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

//    2.) Obtain a list of order with products belong to category “Baby”
//    http://localhost:8040/handson7/order?category=Books

    @GetMapping("")
    public ResponseEntity<List<OrderEntity>> getOrdersByCategory(
            @RequestParam String category
    ) {
        if(Objects.isNull(category) || "".equals(category)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(orderService.getProductsByCategory(category));
    }


//    5.) Get the 3 most recent placed order
//    http://localhost:8040/handson7/order/recent

    @GetMapping("/recent")
    public ResponseEntity<List<OrderEntity>> getRecentOrders() {
        return ResponseEntity.ok(orderService.getRecentOrders());
    }
}
