package com.fooddelivery.foodapp.repositories;

import com.fooddelivery.foodapp.models.Product;


import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    List<Product> findByRestaurantId(Long restaurantId);
}
