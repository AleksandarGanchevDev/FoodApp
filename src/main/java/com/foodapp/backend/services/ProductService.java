package com.foodapp.backend.services;

import com.foodapp.backend.dto.ProductDTO;
import com.foodapp.backend.models.Product;
import com.foodapp.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Async
    public CompletableFuture<List<ProductDTO>> getAllProducts() {
        logger.info("Starting getAllProducts() method");

        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getName(),
                        product.getCategory(),
                        product.getPrice()))
                .collect(Collectors.toList());

        logger.info("Fetched products: {} products found", productDTOs.size());

        return CompletableFuture.completedFuture(productDTOs);
    }

    @Async
    public CompletableFuture<Product> addProduct(Product product) {
        return CompletableFuture.completedFuture(productRepository.save(product));
    }

    @Async
    public CompletableFuture<Product> updateProduct(Long productId, Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        return CompletableFuture.completedFuture(productRepository.save(product));
    }

    @Async
    public CompletableFuture<Void> deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
        return CompletableFuture.completedFuture(null);
    }
}
