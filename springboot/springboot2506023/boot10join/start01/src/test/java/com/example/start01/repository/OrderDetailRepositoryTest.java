package com.example.start01.repository;

import com.example.start01.model.entity.Item;
import com.example.start01.model.entity.OrderDetail;
import com.example.start01.model.entity.User1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
//@DisplayName("ItemRepositoryTest 테스트")
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private EntityManager entityManager;

    @Test
    public void create1(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);

        Optional<User1> user = userRepository.findById(1L);

        orderDetail.setItem(item.orElse(null));
        orderDetail.setUser1(user.orElse(null));

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

    }

    @Test
    public void create2(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);

        Optional<User1> user = userRepository.findById(2L);

        orderDetail.setItem(item.orElse(null));
        orderDetail.setUser1(user.orElse(null));

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        //OrderDetail newOrderDetail = entityManager.merge(orderDetail); // entityManager를 사용하여 merge/
    }
    @Test
    public void create3(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);

        Optional<User1> user = userRepository.findById(3L);

        orderDetail.setItem(item.orElse(null));
        orderDetail.setUser1(user.orElse(null));

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
    }

    @Test
    public void create4(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        Long id = 2L;
        Optional<Item> item = itemRepository.findById(id);

        Optional<User1> user = userRepository.findById(2L);

        orderDetail.setItem(item.orElse(null));
        orderDetail.setUser1(user.orElse(null));

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
    }
    @Test
    public void create5(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        Long id = 2L;
        Optional<Item> item = itemRepository.findById(id);

        Optional<User1> user = userRepository.findById(1L);

        orderDetail.setItem(item.orElse(null));
        orderDetail.setUser1(user.orElse(null));

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
    }

    //병합처리
    @Test
    @Transactional
    @Rollback(false)  // 롤백하지 않도록 설정
    public void create10() {
        // OrderDetail 객체 생성
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());

        // Item과 User1을 데이터베이스에서 조회
        Long id = 1L;
        Optional<Item> itemOpt = itemRepository.findById(id);
        Optional<User1> userOpt = userRepository.findById(1L);

        // Item과 User1이 존재하는 경우에만 설정
        if (itemOpt.isPresent() && userOpt.isPresent()) {
            orderDetail.setItem(itemOpt.get());
            orderDetail.setUser1(userOpt.get());

            // merge를 통해 OrderDetail 저장
            OrderDetail newOrderDetail = entityManager.merge(orderDetail);

            // 추가적인 assert 문을 통해 데이터베이스에 저장된 데이터 확인
            Optional<OrderDetail> savedOrderDetailOpt = orderDetailRepository.findById(newOrderDetail.getId());
            assertTrue(savedOrderDetailOpt.isPresent(), "OrderDetail should be present in the database");

            // 저장된 OrderDetail 정보 출력 (optional)
            System.out.println("Saved OrderDetail: " + savedOrderDetailOpt.get());
        } else {
            throw new IllegalStateException("Item or User not found");
        }
    }

    @Test
    public void printAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();

        if (orderDetails.isEmpty()) {
            System.out.println("No OrderDetails found.");
        } else {
            for (OrderDetail orderDetail : orderDetails) {
                System.out.println("OrderDetail ID: " + orderDetail.getId());
                System.out.println("Order At: " + orderDetail.getOrderAt());

                if (orderDetail.getItem() != null) {
                    System.out.println("Item ID: " + orderDetail.getItem().getId());
                    System.out.println("Item Name: " + orderDetail.getItem().getName());
                } else {
                    System.out.println("Item: null");
                }

                if (orderDetail.getUser1() != null) {
                    System.out.println("User ID: " + orderDetail.getUser1().getId());
                    System.out.println("User Name: " + orderDetail.getUser1().getEmail());
                } else {
                    System.out.println("User: null");
                }
                System.out.println("--------------------------------------");
            }
        }
    }


}
