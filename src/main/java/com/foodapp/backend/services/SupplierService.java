package com.foodapp.backend.services;

import com.foodapp.backend.models.*;
import com.foodapp.backend.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SupplierService {

  @Autowired
  private OrderRepository orderRepo;
  @Autowired
  private UserRepository userRepo;

  public List<Order> getAllOrders() {
    return orderRepo.findAll();
  }

  @Transactional
  public void markAsDelivered(Long orderId) {
    Order order = orderRepo.findById(orderId).orElseThrow();
    if (order.getStatus() != OrderStatus.IN_PROGRESS && order.getStatus() != OrderStatus.COMPLETED) {
      throw new RuntimeException("Order not accepted or already delivered");
    }
    order.setStatus(OrderStatus.COMPLETED);
    orderRepo.save(order);
  }

  @Transactional
  public void acceptOrder(Long orderId, String username) {
    Order order = orderRepo.findById(orderId).orElseThrow();
    if (order.getSupplier() != null)
      throw new RuntimeException("Already accepted");

    User supplier = userRepo.findByUsername(username).orElseThrow();
    order.setSupplier(supplier);
    order.setStatus(OrderStatus.IN_PROGRESS);
    orderRepo.save(order);
  }
}
