package com.bunmetop.service;

import com.bunmetop.domain.Product;
import com.bunmetop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> getAllActiveProducts() {
        return productRepository.findAllByIsActive(true);
    }
    
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Flux<Product> getProductsByMerchant(String merchantId) {
        return productRepository.findAllByMerchantId(merchantId);
    }

    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
    
    public Mono<Product> createProduct(Product product) {
        product.setIsActive(false); // Changed to false: requires admin approval
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public Flux<Product> searchProducts(String query) {
        return productRepository.findByTitleContainingIgnoreCase(query);
    }

    public Mono<Product> approveProduct(String id) {
        return productRepository.findById(id)
                .flatMap(product -> {
                    product.setIsActive(true);
                    product.setUpdatedAt(LocalDateTime.now());
                    return productRepository.save(product);
                });
    }

    public Mono<Product> updateProduct(String id, Product product) {
        return productRepository.findById(id)
                .flatMap(existing -> {
                    existing.setTitle(product.getTitle());
                    existing.setDescription(product.getDescription());
                    existing.setBasePrice(product.getBasePrice());
                    existing.setCategoryId(product.getCategoryId());
                    existing.setIsActive(false); // Re-approval needed after edit
                    existing.setUpdatedAt(LocalDateTime.now());
                    return productRepository.save(existing);
                });
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
