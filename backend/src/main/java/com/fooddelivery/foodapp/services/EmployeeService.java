package com.fooddelivery.foodapp.services;

import com.fooddelivery.foodapp.models.Product;
import com.fooddelivery.foodapp.models.Restaurant;
import com.fooddelivery.foodapp.repositories.ProductRepository;
import com.fooddelivery.foodapp.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
/*
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ProductRepository productRepository;

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    /*
    public void editRestaurant(Long id, Restaurant updatedRestaurant) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        restaurant.setName(updatedRestaurant.getName());
        restaurant.setAddress(updatedRestaurant.getAddress());
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void editProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setName(updatedProduct.getName());
        product.setCategory(updatedProduct.getCategory());
        product.setPrice(updatedProduct.getPrice());
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

*/
}
