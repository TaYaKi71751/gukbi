package com.example.start01.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class HumanDto {
    @Getter
    @Setter
    private long age;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private double height;
    @Getter
    @Setter
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  
    private LocalDateTime birthday;
}
