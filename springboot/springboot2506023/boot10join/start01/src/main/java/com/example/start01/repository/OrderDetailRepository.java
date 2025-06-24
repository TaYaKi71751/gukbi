package com.example.start01.repository;

import com.example.start01.dto.UserItemOrderDetailDto;
import com.example.start01.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query("SELECT new com.example.start01.dto.UserItemOrderDetailDto(u.id, u.account, i.name, o.orderAt) " +
            "FROM OrderDetail o " +
            "JOIN o.user1 u " +  // user를 user1로 변경
            "JOIN o.item i " +
            "WHERE u.id = :userId")
    List<UserItemOrderDetailDto> findOrderDetailsByUserId(@Param("userId") Long userId);
}
