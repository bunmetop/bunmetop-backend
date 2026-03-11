package com.bunmetop.controller;

import com.bunmetop.domain.Order;
import com.bunmetop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/user/{userId}")
    public Flux<Order> getUserOrders(@PathVariable String userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/merchant/{merchantId}")
    public Flux<Order> getMerchantOrders(@PathVariable String merchantId) {
        return orderService.getOrdersByMerchantId(merchantId);
    }
    
    @PatchMapping("/{orderId}/status")
    public Mono<Order> updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}
