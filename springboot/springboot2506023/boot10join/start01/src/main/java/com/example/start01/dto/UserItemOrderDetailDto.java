package com.example.start01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserItemOrderDetailDto {
    private Long userId;
    private String userName;
    private String itemName;
    private LocalDateTime orderAt;

    public UserItemOrderDetailDto(Long userId, String userName, String itemName, LocalDateTime orderAt) {
        this.userId = userId;
        this.userName = userName;
        this.itemName = itemName;
        this.orderAt = orderAt;
    }

    // Getters and Setters
}
