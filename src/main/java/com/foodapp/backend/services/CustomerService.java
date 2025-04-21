package com.foodapp.backend.services;

import com.foodapp.backend.models.*;
import com.foodapp.backend.repositories.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

  private final ProductRepository productRepo;
  private final OrderRepository orderRepo;
  private final OrderProductRepository orderProductRepo;
  private final UserRepository userRepo;

  public CustomerService(ProductRepository p, OrderRepository o, OrderProductRepository op, UserRepository u) {
    this.productRepo = p;
    this.orderRepo = o;
    this.orderProductRepo = op;
    this.userRepo = u;
  }

  public List<Product> getProductsByCategories(List<Category> categories) {
    if (categories == null || categories.isEmpty()) {
      return productRepo.findAll();
    }
    return productRepo.findByCategoryIn(categories);
  }

  public List<Order> getOrdersByUser(String username) {
    User user = userRepo.findByUsername(username).orElseThrow();
    return orderRepo.findByUser(user);
  }

  @Transactional
  public void placeOrder(String username, Map<Long, Integer> productIdQty) {
    User user = userRepo.findByUsername(username).orElseThrow();

    Order order = new Order();
    order.setUser(user);
    order.setOrderDate(LocalDate.now());
    order.setStatus(OrderStatus.PENDING);
    orderRepo.save(order);

    for (Map.Entry<Long, Integer> e : productIdQty.entrySet()) {
      Product product = productRepo.findById(e.getKey()).orElseThrow();
      OrderProduct op = new OrderProduct();
      op.setOrder(order);
      op.setProduct(product);
      op.setQuantity(e.getValue());
      orderProductRepo.save(op);
    }
  }
}
