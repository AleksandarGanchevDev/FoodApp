package com.foodapp.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

  private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

  private final JwtUtil jwtUtil;
  private final UserDetailsServiceImpl userDetailsService;

  public JwtFilter(JwtUtil jwtUtil, UserDetailsServiceImpl uds) {
    this.jwtUtil = jwtUtil;
    this.userDetailsService = uds;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws ServletException, IOException {

    String header = req.getHeader("Authorization");
    String token = null, username = null;

    if (header != null && header.startsWith("Bearer ")) {
      token = header.substring(7);
      username = jwtUtil.extractUsername(token);
      logger.info("Extracted token for username: {}", username);
    }

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);
      logger.info("Loaded user details for: {}", username);

      if (jwtUtil.validateToken(token)) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

        SecurityContextHolder.getContext().setAuthentication(auth);
        logger.info("Authentication set for user: {}", username);
      } else {
        logger.warn("Invalid JWT token for user: {}", username);
      }
    } else {
      if (username == null) {
        logger.warn("No username found in token or Authorization header.");
      }
      if (SecurityContextHolder.getContext().getAuthentication() != null) {
        logger.info("User already authenticated, skipping token validation.");
      }
    }

    chain.doFilter(req, res);
  }
}
