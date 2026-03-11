package com.bunmetop.repository;

import com.bunmetop.domain.Merchant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MerchantRepository extends ReactiveMongoRepository<Merchant, String> {
    Mono<Merchant> findByUserId(String userId);
}
