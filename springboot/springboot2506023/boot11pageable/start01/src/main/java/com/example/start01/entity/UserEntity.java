package com.example.start01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private int age;

    // Getters and Setters
}
