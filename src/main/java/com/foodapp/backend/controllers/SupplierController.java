package com.foodapp.backend.controllers;

import com.foodapp.backend.services.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import com.foodapp.backend.models.Order;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

  @Autowired
  private SupplierService supplierService;

  @GetMapping("/orders")
  public ResponseEntity<List<Order>> getAllOrders() {
    return ResponseEntity.ok(supplierService.getAllOrders());
  }

  @PostMapping("/complete/{orderId}")
  public ResponseEntity<String> markAsDelivered(@PathVariable Long orderId) {
    supplierService.markAsDelivered(orderId);
    return ResponseEntity.ok("Order marked as delivered");
  }

  @PostMapping("/deliver/{orderId}")
  public ResponseEntity<String> acceptOrder(@PathVariable Long orderId, Authentication auth) {
    supplierService.acceptOrder(orderId, auth.getName());
    return ResponseEntity.ok("Order accepted");
  }

}
