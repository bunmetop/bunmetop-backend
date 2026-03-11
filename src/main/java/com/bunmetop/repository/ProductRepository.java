package com.bunmetop.repository;

import com.bunmetop.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<Product> findAllByIsActive(Boolean isActive);
    Flux<Product> findAllByMerchantId(String merchantId);
    Flux<Product> findByTitleContainingIgnoreCase(String title);
}
