package com.example.start01.repository;


import com.example.start01.dto.UserItemOrderDetailDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
//@DisplayName("ItemRepositoryTest 테스트")
@SpringBootTest
public class AllTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;



    @Test
    public void printUserOrderDetails() {
        Long userId=1l;
        List<UserItemOrderDetailDto> orderDetails = orderDetailRepository.findOrderDetailsByUserId(userId);

        orderDetails.forEach(orderDetail -> {
            System.out.println("User1 ID: " + orderDetail.getUserId());
            System.out.println("User1 Name: " + orderDetail.getUserName());
            System.out.println("Item Name: " + orderDetail.getItemName());
            System.out.println("Order At: " + orderDetail.getOrderAt());
            System.out.println("-----------------------------");
        });
    }


}
