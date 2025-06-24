package com.example.start01.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity  //클래스를 jpa 테이블로 사용
@AllArgsConstructor //모든 필드를 매개변수로 가지는 생성자
@NoArgsConstructor //기본 생성자
@ToString
@Getter
@Setter
public class LoginEntity {
    @Id     //프라이머리키  primary key
    @GeneratedValue     //자동으로 값이 증가하는 컬럼
    private Integer id;

    @Column
    private String name;
    @Column
    private String password;



}
