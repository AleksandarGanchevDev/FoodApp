package com.foodapp.backend.controllers;

import java.util.concurrent.CompletableFuture;
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
  public CompletableFuture<AuthResponse> register(@RequestBody User user) {
    return userService.register(user).thenApply(AuthResponse::new);
  }

  @PostMapping("/login")
  public CompletableFuture<AuthResponse> login(@RequestBody AuthRequest request) {
    return userService.login(request).thenApply(AuthResponse::new);
  }
}
