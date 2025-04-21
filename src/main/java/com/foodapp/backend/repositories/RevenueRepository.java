package com.foodapp.backend.repositories;

import com.foodapp.backend.models.Revenue;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {
  List<Revenue> findByDateBetween(LocalDate start, LocalDate end);
}
