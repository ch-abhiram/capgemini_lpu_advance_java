package com.book_service.service;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_service.client.BookClient;
import com.book_service.dto.BookDTO;
import com.book_service.model.Order;
import com.book_service.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private BookClient bookClient;

    public Order createOrder(Order order){

        BookDTO book = bookClient.getBookById(order.getBookId());

        double total = book.getPrice() * order.getQuantity();

        order.setTotalPrice(total);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        return repository.save(order);
    }

}
