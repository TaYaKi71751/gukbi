package com.human.dto;

public class HobbyDto {
    private Integer id;
    private String hobby;

    public HobbyDto(Integer id, String hobby) {
        this.id = id;
        this.hobby = hobby;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }

    @Override
    public String toString() {
        return hobby;
    }
}
