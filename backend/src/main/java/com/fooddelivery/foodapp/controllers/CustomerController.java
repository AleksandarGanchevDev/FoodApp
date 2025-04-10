package com.fooddelivery.foodapp.controllers;

import com.fooddelivery.foodapp.models.Customer;
import com.fooddelivery.foodapp.models.Order;
import com.fooddelivery.foodapp.models.Product;
import com.fooddelivery.foodapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    /*
    @PostMapping("/register")
    public void registerCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public boolean loginCustomer(@RequestParam String username, @RequestParam String password) {
        return customerService.loginCustomer(username, password);
    }

    @GetMapping("/browse")
    public List<Product> browseFoodByCategory(@RequestParam String category) {
        return customerService.browseFoodByCategory(category);
    }

    @PostMapping("/order")
    public void placeOrder(@RequestBody Order order) {
        customerService.placeOrder(order);
    }

    @GetMapping("/order/status")
    public String getOrderStatus(@RequestParam Long orderId) {
        return customerService.getOrderStatus(orderId);
    }

     */
}
