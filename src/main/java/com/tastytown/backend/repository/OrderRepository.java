package com.tastytown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastytown.backend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String>{
    
}
