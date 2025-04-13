package com.foodapp.backend.services;

import com.foodapp.backend.models.Restaurant;
import com.foodapp.backend.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Async
    public CompletableFuture<List<Restaurant>> getAllRestaurants() {
        return CompletableFuture.completedFuture(restaurantRepository.findAll());
    }

    @Async
    public CompletableFuture<Restaurant> addRestaurant(Restaurant restaurant) {
        return CompletableFuture.completedFuture(restaurantRepository.save(restaurant));
    }

    @Async
    public CompletableFuture<Restaurant> updateRestaurant(Long restaurantId, Restaurant details) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Not found"));
        restaurant.setName(details.getName());
        restaurant.setAddress(details.getAddress());
        return CompletableFuture.completedFuture(restaurantRepository.save(restaurant));
    }

    @Async
    public CompletableFuture<Void> deleteRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("Not found"));
        restaurantRepository.delete(restaurant);
        return CompletableFuture.completedFuture(null);
    }
}
