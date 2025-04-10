package com.fooddelivery.foodapp.models;

//import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Date orderDate;
    private String status;

    /*
    @ManyToOne
    private Customer customer;

    @ManyToMany
    @JoinTable(
      name = "order_products",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @OneToOne
    private Supplier supplier;

     */
}
