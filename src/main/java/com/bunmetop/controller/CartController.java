package com.bunmetop.controller;

import com.bunmetop.domain.Cart;
import com.bunmetop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/user/{userId}")
    public Mono<Cart> getCartByUserId(@PathVariable String userId) {
        return cartService.getCartByUserId(userId);
    }

    @PutMapping
    public Mono<Cart> updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }
}
