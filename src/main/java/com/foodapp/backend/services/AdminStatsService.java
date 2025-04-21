package com.foodapp.backend.services;

import com.foodapp.backend.models.Income;
import com.foodapp.backend.models.Revenue;
import com.foodapp.backend.repositories.IncomeRepository;
import com.foodapp.backend.repositories.RevenueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminStatsService {

  @Autowired
  private IncomeRepository incomeRepo;
  @Autowired
  private RevenueRepository revenueRepo;

  public Map<String, Double> getSupplierIncome(LocalDate start, LocalDate end) {
    List<Income> incomes = incomeRepo.findByDateBetween(start, end);
    return incomes.stream()
        .collect(Collectors.groupingBy(i -> i.getSupplier().getUsername(),
            Collectors.summingDouble(Income::getAmount)));
  }

  public Map<String, Double> getCompanyRevenue(LocalDate start, LocalDate end) {
    return revenueRepo.findByDateBetween(start, end).stream()
        .collect(Collectors.toMap(
            revenue -> revenue.getRestaurant().getName(),
            Revenue::getAmount));
  }
}
