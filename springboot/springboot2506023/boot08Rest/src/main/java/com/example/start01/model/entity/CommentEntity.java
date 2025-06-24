package com.example.start01.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor //모든 필드를 매개변수로 가지는 생성자
@NoArgsConstructor //기본 생성자
@ToString
@Getter
@Setter
public class CommentEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer loginEntityId;
    @Column
    private String name;
    @Column
    private String comments;

}
