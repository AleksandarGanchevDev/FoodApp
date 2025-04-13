package com.foodapp.backend.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.foodapp.backend.models.User;
import com.foodapp.backend.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository repo;

  public UserDetailsServiceImpl(UserRepository repo) {
    this.repo = repo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = repo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    String authority = user.getRole().name();
    System.out.println("DEBUG: Loaded user " + username + " with role " + authority);

    return org.springframework.security.core.userdetails.User
        .withUsername(user.getUsername())
        .password(user.getPassword())
        .authorities(user.getRole().name())
        .build();
  }
}
