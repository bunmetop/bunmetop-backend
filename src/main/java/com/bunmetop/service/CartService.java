package com.bunmetop.service;

import com.bunmetop.domain.Cart;
import com.bunmetop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Mono<Cart> getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId)
                .switchIfEmpty(cartRepository.save(Cart.builder().userId(userId).build()));
    }

    public Mono<Cart> updateCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
