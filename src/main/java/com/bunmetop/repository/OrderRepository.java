package com.bunmetop.repository;

import com.bunmetop.domain.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
    Flux<Order> findAllByUserId(String userId);
    Flux<Order> findAllByItemsMerchantId(String merchantId);
}
