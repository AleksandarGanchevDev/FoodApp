package com.fooddelivery.foodapp.models;

//import jakarta.persistence.*;

import java.util.List;

public class Customer {
    private String id;
    private String username;
    private String password;
    private String email;
  
    //@OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
