package com.foodapp.backend.controllers;

import com.foodapp.backend.dto.AuthRequest;
import com.foodapp.backend.dto.AuthResponse;
import com.foodapp.backend.services.UserService;
import com.foodapp.backend.models.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final UserService userService;

  public AuthController(UserService service) {
    this.userService = service;
  }

  @PostMapping("/register")
  public AuthResponse register(@RequestBody User user) {
    return new AuthResponse(userService.register(user));
  }

  @PostMapping("/login")
  public AuthResponse login(@RequestBody AuthRequest request) {
    return new AuthResponse(userService.login(request));
  }
}