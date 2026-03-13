package com.book_service.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.book_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}