package com.foodapp.backend.controllers;

import com.foodapp.backend.services.CustomerService;
import com.foodapp.backend.models.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/products")
  public List<Product> getByCategories(@RequestParam(required = false) List<Category> categories) {
    return customerService.getProductsByCategories(categories);
  }

  @GetMapping("/orders")
  public List<Order> getCustomerOrders(Authentication auth) {
    return customerService.getOrdersByUser(auth.getName());
  }

  @PostMapping("/order")
  public ResponseEntity<String> placeOrder(@RequestBody Map<Long, Integer> productIdQty, Authentication auth) {
    customerService.placeOrder(auth.getName(), productIdQty);
    return ResponseEntity.ok("Order placed");
  }
}
