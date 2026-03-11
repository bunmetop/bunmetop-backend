package com.bunmetop.service;

import com.bunmetop.domain.Merchant;
import com.bunmetop.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public Flux<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    public Mono<Merchant> getMerchantById(String id) {
        return merchantRepository.findById(id);
    }

    public Mono<Merchant> createMerchant(Merchant merchant) {
        merchant.setCreatedAt(LocalDateTime.now());
        merchant.setUpdatedAt(LocalDateTime.now());
        merchant.setIsVerified(false);
        return merchantRepository.save(merchant);
    }

    public Mono<Merchant> getMerchantByUserId(String userId) {
        return merchantRepository.findByUserId(userId);
    }

    public Mono<Merchant> updateMerchant(String id, Merchant merchant) {
        return merchantRepository.findById(id)
                .flatMap(existing -> {
                    existing.setStoreName(merchant.getStoreName());
                    existing.setDescription(merchant.getDescription());
                    existing.setAddress(merchant.getAddress());
                    existing.setPhone(merchant.getPhone());
                    existing.setUpdatedAt(LocalDateTime.now());
                    return merchantRepository.save(existing);
                });
    }
}
