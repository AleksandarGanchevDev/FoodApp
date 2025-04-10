package com.fooddelivery.foodapp.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@Service
public class TestDataService {

    private final Firestore firestore;

    public TestDataService(Firestore firestore) {
        this.firestore = firestore;
    }

    @PostConstruct
    public void initTestData() throws ExecutionException, InterruptedException {
        Map<String, Object> restaurant = new HashMap<>();
        restaurant.put("name", "Пицария Италия");
        restaurant.put("address", "София, бул. Витоша 12");
        restaurant.put("categories", Arrays.asList("пица", "паста"));
        restaurant.put("isActive", true);

        ApiFuture<WriteResult> future = firestore.collection("restaurants")
                .document("rest1")
                .set(restaurant);

        System.out.println("!!!!!!!Тестови данни добавени в: " + future.get().getUpdateTime());
    }
}