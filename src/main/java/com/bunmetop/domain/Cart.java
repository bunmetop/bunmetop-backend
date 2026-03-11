package com.bunmetop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carts")
public class Cart {

    @Id
    private String id;
    
    private String userId;
    private List<CartItem> items;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class CartItem {
    private String productId;
    private Integer quantity;
}
