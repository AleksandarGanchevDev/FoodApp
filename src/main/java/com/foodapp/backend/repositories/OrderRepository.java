package com.foodapp.backend.repositories;

import com.foodapp.backend.models.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.foodapp.backend.models.User;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Optional<Order> findById(Long id);

  List<Order> findByUser(User user);

  List<Order> findBySupplier(User supplier);
}