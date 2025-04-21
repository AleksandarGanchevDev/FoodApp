package com.foodapp.backend.repositories;

import com.foodapp.backend.models.Income;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
  List<Income> findByDateBetween(LocalDate start, LocalDate end);
}
