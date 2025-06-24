package com.example.start01.model.request;

import com.example.start01.model.entity.CommentEntity;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor //모든 필드를 매개변수로 가지는 생성자
@NoArgsConstructor //기본 생성자
@ToString
@Getter
@Setter
public class CommentDto {
    private Integer id;
    private Integer loginEntityId;
    private String name;
    private String comments;
    public CommentEntity toEntity(){
        return new CommentEntity(id,loginEntityId,name,comments);
    }
}
