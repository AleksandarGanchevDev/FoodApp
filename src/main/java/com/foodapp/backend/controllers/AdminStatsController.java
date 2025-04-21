package com.foodapp.backend.controllers;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import com.foodapp.backend.services.AdminStatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/admin")
public class AdminStatsController {

  @Autowired
  private AdminStatsService adminStatsService;

  @GetMapping("/supplier-income")
  public ResponseEntity<Map<String, Double>> supplierIncome(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    return ResponseEntity.ok(adminStatsService.getSupplierIncome(start, end));
  }

  @GetMapping("/company-revenue")
  public ResponseEntity<Map<String, Double>> companyRevenue(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end) {
    return ResponseEntity.ok(adminStatsService.getCompanyRevenue(start, end));
  }

}
