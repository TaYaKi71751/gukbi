package com.example.start01.model.request;

import com.example.start01.model.entity.LoginEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginDto {
    private Integer id;
    private String name;
    private String password;

    public LoginEntity toEntity(){
        return new LoginEntity(id,name,password);
    }


}
