package com.foodapp.backend.controllers;

// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

  // This endpoint is only accessible by 'ADMIN' role
  @GetMapping("/admin")
  // @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLOYEE')")
  public String adminEndpoint() {
    return "Admin access granted!";
  }

  // This endpoint is accessible by both 'USER' and 'ADMIN' roles
  @GetMapping("/user")
  // @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
  public String userEndpoint() {
    return "User access granted!";
  }
}
