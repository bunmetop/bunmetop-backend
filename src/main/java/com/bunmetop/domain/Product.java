package com.bunmetop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    
    private String merchantId;
    private String categoryId;
    
    private String title;
    private String slug;
    private String description;
    
    private BigDecimal basePrice;
    private Boolean isActive;
    
    private java.util.List<String> images;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
