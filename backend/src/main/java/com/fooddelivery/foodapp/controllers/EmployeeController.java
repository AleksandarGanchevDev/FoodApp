package com.fooddelivery.foodapp.controllers;

import com.fooddelivery.foodapp.models.Product;
import com.fooddelivery.foodapp.models.Restaurant;
import com.fooddelivery.foodapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
/*
    @PostMapping("/restaurant")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        employeeService.addRestaurant(restaurant);
    }


    @PutMapping("/restaurant/{id}")
    public void editRestaurant(@PathVariable Long id, @RequestBody Restaurant updatedRestaurant) {
        employeeService.editRestaurant(id, updatedRestaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        employeeService.deleteRestaurant(id);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        employeeService.addProduct(product);
    }

    @PutMapping("/product/{id}")
    public void editProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        employeeService.editProduct(id, updatedProduct);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        employeeService.deleteProduct(id);
    }

     */
}
