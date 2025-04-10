package com.fooddelivery.foodapp.models;

//import jakarta.persistence.*;
import java.util.List;

public class Restaurant {
    private Long id;
    private String name;
    private String address;

    /*
    @ManyToMany
    @JoinTable(
      name = "restaurant_products",
      joinColumns = @JoinColumn(name = "restaurant_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))

     */
    private List<Product> products;

}
