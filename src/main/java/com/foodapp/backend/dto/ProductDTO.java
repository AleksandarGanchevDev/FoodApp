package com.foodapp.backend.dto;

import com.foodapp.backend.models.Category;

public class ProductDTO {
  private Long id;
  private String name;
  private Category category;
  private double price;

  // Constructor, Getters, Setters
  public ProductDTO(Long id, String name, Category category, double price) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
