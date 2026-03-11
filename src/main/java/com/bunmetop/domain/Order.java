package com.bunmetop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    
    private String userId;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private String status;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class OrderItem {
    private String productId;
    private String merchantId;
    private String title;
    private Integer quantity;
    private BigDecimal price;
}
