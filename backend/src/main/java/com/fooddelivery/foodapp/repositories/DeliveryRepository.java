package com.fooddelivery.foodapp.repositories;


import com.fooddelivery.foodapp.models.Delivery;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DeliveryRepository {
    List<Delivery> findBySupplierId(Long supplierId);
    List<Delivery> findByStatus(String status);
}
