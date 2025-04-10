package com.fooddelivery.foodapp.services;


import com.fooddelivery.foodapp.models.Delivery;
import com.fooddelivery.foodapp.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class SupplierService {
/*
    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getPendingDeliveries() {
        return deliveryRepository.findByStatus("Pending");
    }

    public boolean acceptDelivery(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new IllegalArgumentException("Delivery not found"));
        if (!"Pending".equals(delivery.getStatus())) {
            return false; 
        }
        delivery.setStatus("Accepted");
        deliveryRepository.save(delivery);
        return true;
    }

    public String getDeliveryStatus(Long deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new IllegalArgumentException("Delivery not found"));
        return delivery.getStatus();
    }
*/

}


