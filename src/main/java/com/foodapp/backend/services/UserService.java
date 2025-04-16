package com.foodapp.backend.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.foodapp.backend.models.User;
import com.foodapp.backend.repositories.UserRepository;
import com.foodapp.backend.security.JwtUtil;
import com.foodapp.backend.dto.AuthRequest;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public UserService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil) {
    this.userRepository = repo;
    this.passwordEncoder = encoder;
    this.jwtUtil = jwtUtil;
  }

  public String register(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return jwtUtil.generateToken(user.getUsername());
  }

  public String login(AuthRequest req) {
    return userRepository.findByUsername(req.username)
        .filter(u -> passwordEncoder.matches(req.password, u.getPassword()))
        .map(u -> jwtUtil.generateToken(u.getUsername()))
        .orElseThrow(() -> new RuntimeException("Invalid credentials"));
  }
}
