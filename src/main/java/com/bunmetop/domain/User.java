package com.bunmetop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;
    
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private Boolean enabled;
    private List<String> roles;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
