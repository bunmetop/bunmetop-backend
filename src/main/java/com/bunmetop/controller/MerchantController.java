package com.bunmetop.controller;

import com.bunmetop.domain.Merchant;
import com.bunmetop.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping
    public Flux<Merchant> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

    @GetMapping("/{id}")
    public Mono<Merchant> getMerchantById(@PathVariable String id) {
        return merchantService.getMerchantById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Merchant> createMerchant(@RequestBody Merchant merchant) {
        return merchantService.createMerchant(merchant);
    }

    @GetMapping("/user/{userId}")
    public Mono<Merchant> getMerchantByUserId(@PathVariable String userId) {
        return merchantService.getMerchantByUserId(userId);
    }

    @PutMapping("/{id}")
    public Mono<Merchant> updateMerchant(@PathVariable String id, @RequestBody Merchant merchant) {
        return merchantService.updateMerchant(id, merchant);
    }
}
