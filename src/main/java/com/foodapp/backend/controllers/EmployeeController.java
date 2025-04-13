package com.foodapp.backend.controllers;

import com.foodapp.backend.dto.ProductDTO;
import com.foodapp.backend.models.Product;
import com.foodapp.backend.models.Restaurant;
import com.foodapp.backend.services.ProductService;
import com.foodapp.backend.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
  public CompletableFuture<List<ProductDTO>> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping("/products")
  public CompletableFuture<ResponseEntity<Product>> addProduct(@RequestBody Product product) {
    return productService.addProduct(product).thenApply(ResponseEntity::ok);
  }

  @PutMapping("/products/{id}")
  public CompletableFuture<ResponseEntity<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProduct(id, product).thenApply(ResponseEntity::ok);
  }

  @DeleteMapping("/products/{id}")
  public CompletableFuture<ResponseEntity<Void>> deleteProduct(@PathVariable Long id) {
    return productService.deleteProduct(id).thenApply(v -> ResponseEntity.noContent().build());
  }

  @GetMapping("/restaurants")
  public CompletableFuture<List<Restaurant>> getAllRestaurants() {
    return restaurantService.getAllRestaurants();
  }

  @PostMapping("/restaurants")
  public CompletableFuture<ResponseEntity<Restaurant>> addRestaurant(@RequestBody Restaurant restaurant) {
    return restaurantService.addRestaurant(restaurant).thenApply(ResponseEntity::ok);
  }

  @PutMapping("/restaurants/{id}")
  public CompletableFuture<ResponseEntity<Restaurant>> updateRestaurant(@PathVariable Long id,
      @RequestBody Restaurant restaurant) {
    return restaurantService.updateRestaurant(id, restaurant).thenApply(ResponseEntity::ok);
  }

  @DeleteMapping("/restaurants/{id}")
  public CompletableFuture<ResponseEntity<Void>> deleteRestaurant(@PathVariable Long id) {
    return restaurantService.deleteRestaurant(id).thenApply(v -> ResponseEntity.noContent().build());
  }
}
