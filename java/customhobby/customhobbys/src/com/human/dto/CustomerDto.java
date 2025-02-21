package com.human.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerDto {
    private Integer id;
    private String name;
    private Double height;
    private LocalDateTime birthday;
    private List<HobbyDto> hobbys;

    public CustomerDto(Integer id, String name, Double height, LocalDateTime birthday, List<HobbyDto> hobbys) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.birthday = birthday;
        this.hobbys = hobbys;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Double getHeight() { return height; }
    public LocalDateTime getBirthday() { return birthday; }
    public List<HobbyDto> getHobbys() { return hobbys; }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Height: %.2f, Birthday: %s, Hobbies: %s",
                id, name, height, birthday, hobbys);
    }
}
