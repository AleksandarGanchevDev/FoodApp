package com.fooddelivery.foodapp.services;

import com.fooddelivery.foodapp.models.Customer;
import com.fooddelivery.foodapp.models.Order;
import com.fooddelivery.foodapp.models.Product;
import com.fooddelivery.foodapp.repositories.CustomerRepository;
import com.fooddelivery.foodapp.repositories.OrderRepository;
import com.fooddelivery.foodapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    /*
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public void registerCustomer(Customer customer) {
        if (customerRepository.existsByUsername(customer.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }
        customerRepository.save(customer);
    }

    public boolean loginCustomer(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        return customer != null && customer.getPassword().equals(password);
    }

    public List<Product> browseFoodByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public void placeOrder(Order order) {
        orderRepository.save(order);
    }

    public String getOrderStatus(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found"));
        return order.getStatus();
    }
    */
}
