package com.example.start01.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
@ToString(exclude = {"user1","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1
    //@ManyToOne( cascade = CascadeType.ALL)
    //@JoinColumn(name = "custom_user_id") // 외래 키 컬럼 이름 지정
    @ManyToOne
    private User1 user1; // user1_id

    // N : 1
    @ManyToOne
    private Item item;//item_id
}
