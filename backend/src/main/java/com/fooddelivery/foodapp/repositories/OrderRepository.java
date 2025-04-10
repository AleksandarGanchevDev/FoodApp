package com.fooddelivery.foodapp.repositories;

import com.fooddelivery.foodapp.models.Order;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository{
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByStatus(String status);
}
