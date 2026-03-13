package com.book_service.OrderController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book_service.model.Order;
import com.book_service.repository.OrderRepository;
import com.book_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderService service;

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return service.createOrder(order);
    }

    @GetMapping
    public List<Order> getOrders(){
        return repository.findAll();
    }

}