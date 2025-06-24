package com.example.start02.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanDto {
    private long age;
    private String name;
    private double height;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  
    private LocalDateTime birthday;
}
