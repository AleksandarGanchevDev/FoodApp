package com.fooddelivery.foodapp.models;

//import jakarta.persistence.*;

import java.util.List;

public class Product {

    private String id;
    private String name;
    private String category;
    private Double price;

    //@ManyToMany(mappedBy = "products")
    private List<Restaurant> restaurants;

}
