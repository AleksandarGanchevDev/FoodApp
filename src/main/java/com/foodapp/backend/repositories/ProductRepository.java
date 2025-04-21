package com.foodapp.backend.repositories;

import com.foodapp.backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import com.foodapp.backend.models.Category;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategoryIn(List<Category> categories);
}
