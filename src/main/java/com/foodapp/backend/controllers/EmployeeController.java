package com.foodapp.backend.controllers;

import com.foodapp.backend.models.Product;
import com.foodapp.backend.models.Restaurant;
import com.foodapp.backend.services.ProductService;
import com.foodapp.backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

  private final ProductService productService;
  private final RestaurantService restaurantService;

  @Autowired
  public EmployeeController(ProductService productService, RestaurantService restaurantService) {
    this.productService = productService;
    this.restaurantService = restaurantService;
  }

  @GetMapping("/admin")
  public String adminEndpoint() {
    return "Admin access granted!";
  }

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping("/products")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    return ResponseEntity.ok(productService.addProduct(product));
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return ResponseEntity.ok(productService.updateProduct(id, product));
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/restaurants")
  public List<Restaurant> getAllRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  @PostMapping("/restaurants")
  public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
    return ResponseEntity.ok(restaurantService.addRestaurant(restaurant));
  }

  @PutMapping("/restaurants/{id}")
  public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,
      @RequestBody Restaurant restaurant) {
    return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurant));
  }

  @DeleteMapping("/restaurants/{id}")
  public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
    restaurantService.deleteRestaurant(id);
    return ResponseEntity.noContent().build();
  }
}