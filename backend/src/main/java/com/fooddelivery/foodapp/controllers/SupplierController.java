package com.fooddelivery.foodapp.controllers;

import com.fooddelivery.foodapp.models.Order;
import com.fooddelivery.foodapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/orders/pending")
    public List<Order> getPendingOrders() {
        return supplierService.getPendingOrders();
    }

    @PostMapping("/order/accept")
    public boolean acceptOrder(@RequestParam Long orderId) {
        return supplierService.acceptOrder(orderId);
    }

    @GetMapping("/order/status")
    public String getOrderStatus(@RequestParam Long orderId) {
        return supplierService.getOrderStatus(orderId);
    }
}
*/