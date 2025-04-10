package com.fooddelivery.foodapp.models;

//import jakarta.persistence.*;

public class Supplier {
    private String id;
    private String username;
    private String password;
    private String email;

    //@OneToOne(mappedBy = "supplier")
    private Order order;

}
