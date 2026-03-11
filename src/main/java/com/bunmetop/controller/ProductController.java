package com.bunmetop.controller;

import com.bunmetop.domain.Product;
import com.bunmetop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<Product> getAllActiveProducts() {
        return productService.getAllActiveProducts();
    }

    @GetMapping("/search")
    public Flux<Product> searchProducts(@RequestParam String q) {
        return productService.searchProducts(q);
    }
    
    @GetMapping("/admin/all")
    public Flux<Product> getAllProductsForAdmin() {
        return productService.getAllProducts();
    }

    @GetMapping("/merchant/{merchantId}")
    public Flux<Product> getProductsByMerchant(@PathVariable String merchantId) {
        return productService.getProductsByMerchant(merchantId);
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}/approve")
    public Mono<Product> approveProduct(@PathVariable String id) {
        return productService.approveProduct(id);
    }

    @PutMapping("/{id}")
    public Mono<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
