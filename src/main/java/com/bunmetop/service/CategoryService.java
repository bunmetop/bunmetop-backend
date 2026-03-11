package com.bunmetop.service;

import com.bunmetop.domain.Category;
import com.bunmetop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Flux<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Mono<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }
    
    public Mono<Category> createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
