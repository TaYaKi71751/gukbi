package com.example.start01.repository;

import com.example.start01.model.entity.Item;
import com.example.start01.model.entity.OrderDetail;
import com.example.start01.model.entity.User1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
//@DisplayName("ItemRepositoryTest 테스트")
@SpringBootTest
public class User1RepositoryTest {

    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Test
    //@Transactional
    public void create1(){
        // String sql = insert into user1 (%s, %s , %d ) value (account, email, age);
        User1 user1 = new User1();
        user1.setAccount("TestUser01");
        user1.setEmail("TestUser01@gmail.com");
        user1.setPhoneNumber("010-1111-1111");
        user1.setCreatedAt(LocalDateTime.now());
        user1.setCreatedBy("TestUser1");

        User1 newUser1 = userRepository.save(user1);
        System.out.println("newUser1 : "+ newUser1);

    }


    @Test
    public void create2(){
        // String sql = insert into user1 (%s, %s , %d ) value (account, email, age);
        User1 user1 = new User1();
        user1.setAccount("TestUser02");
        user1.setEmail("TestUser02@gmail.com");
        user1.setPhoneNumber("010-1111-2222");
        user1.setCreatedAt(LocalDateTime.now());
        user1.setCreatedBy("TestUser2");

        User1 newUser1 = userRepository.save(user1);
        System.out.println("newUser1 : "+ newUser1);

    }

    @Test
    public void create3(){
        // String sql = insert into user1 (%s, %s , %d ) value (account, email, age);
        User1 user1 = new User1();
        user1.setAccount("TestUser03");
        user1.setEmail("TestUser03@gmail.com");
        user1.setPhoneNumber("010-1111-3333");
        user1.setCreatedAt(LocalDateTime.now());
        user1.setCreatedBy("TestUser3");

        User1 newUser1 = userRepository.save(user1);
        System.out.println("newUser1 : "+ newUser1);

    }

    //한번에 넣는 방법
    @Test
    public void create4() {
        //user >> Item  >> OrderDetail
        // 새로운 유저 생성
        User1 user1 = new User1();
        user1.setAccount("TestUser04");
        user1.setEmail("TestUser04@gmail.com");
        user1.setPhoneNumber("010-1111-4444");
        user1.setCreatedAt(LocalDateTime.now());
        user1.setCreatedBy("TestUser4");
        // User를 데이터베이스에 먼저 저장
        User1 newUser1 = userRepository.save(user1);
        // OrderDetail과 Item 리스트 생성
        List<OrderDetail> orderDetailList = new ArrayList<>();
        // 여러 개의 OrderDetail과 Item 생성
        for (int i = 0; i < 3; i++) {
            // 새로운 아이템 생성
            Item item = new Item();
            item.setName("TestItem" + (i + 4));  // 이름에 숫자 추가
            item.setPrice(44000 + (i * 1000));    // 가격을 다르게 설정
            item.setContent("Test item content " + (i + 4));
            // Item을 데이터베이스에 먼저 저장
            Item newItem = itemRepository.save(item);  // itemRepository를 사용하여 Item을 저장
            // 새로운 OrderDetail 생성
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderAt(LocalDateTime.now());
            orderDetail.setUser1(newUser1);  // 방금 저장한 User1 설정
            orderDetail.setItem(newItem);   // 저장된 Item을 설정
            // OrderDetail을 데이터베이스에 저장
            orderDetailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);  // OrderDetail을 리스트에 추가
        }

        // User와 OrderDetail 관계 설정
        newUser1.setOrderDetailList(orderDetailList);

        // 유저와 연관된 OrderDetail 리스트를 업데이트
        userRepository.save(newUser1); // 혹은 별도의 저장 없이 User와의 관계만 유지하고자 할 경우 이 단계는 생략할 수 있음.

        System.out.println("newUser1 : " + newUser1);
    }
    @Test
    public void create5() {
        // 새로운 유저 생성
        User1 user1 = new User1();
        user1.setAccount("TestUser04");
        user1.setEmail("TestUser04@gmail.com");
        user1.setPhoneNumber("010-1111-4444");
        user1.setCreatedAt(LocalDateTime.now());
        user1.setCreatedBy("TestUser4");

        // OrderDetail과 Item 리스트 생성
        List<OrderDetail> orderDetailList = new ArrayList<>();

        // 여러 개의 OrderDetail과 Item 생성
        for (int i = 0; i < 3; i++) {
            // 새로운 아이템 생성
            Item item = new Item();
            item.setName("TestItem" + (i + 4));
            item.setPrice(44000 + (i * 1000));
            item.setContent("Test item content " + (i + 4));

            // 새로운 OrderDetail 생성
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderAt(LocalDateTime.now());
            orderDetail.setUser1(user1);  // 아직 저장하지 않은 User1을 바로 설정 가능
            orderDetail.setItem(item);   // 저장하지 않은 Item을 바로 설정 가능

            // 리스트에 추가
            orderDetailList.add(orderDetail);
        }

        // User와 OrderDetail 관계 설정
        user1.setOrderDetailList(orderDetailList);

        // User를 저장하면 OrderDetail과 Item도 자동으로 저장됨
        userRepository.save(user1);

        System.out.println("newUser1 : " + user1);
    }

    @Test
    //한명의 유저를 찾아서  가져온다.
    public void read0(){
        // select * from user where id = ?
        Optional<User1> user = userRepository.findByAccountAndEmail("TestUser03","TestUser03@gmail.com");
        User1 user1= user.orElse(null);

        System.out.println("-------"+user1);

    }

    @Test
    //한명의 유저를 찾아서 찾은 유저 가 가지고 있는 orderDetail들을 가져온다.
    public void read1(){
        // select * from user where id = ?
        Optional<User1> user = userRepository.findByAccountAndEmail("TestUser03","TestUser03@gmail.com");
        System.out.println(user);
        user.ifPresent(selectUser ->{
            System.out.println("-------------------------------------------------");
            System.out.println(selectUser);
            selectUser.getOrderDetailList().stream().forEach(detail ->{
                System.out.println(detail);
                Item item = detail.getItem();
                System.out.println("select item : \n"+item);
            });
        });
    }
    @Test//모든 유저와  유저별 모든 orderDetail를 읽어 온다.
    public void read2() {
        // 모든 유저를 List로 가져옴
        List<User1> user1 = userRepository.findAll();

        // 유저가 존재할 경우 처리
        if (!user1.isEmpty()) {
            user1.forEach(selectUser -> {
                System.out.println(selectUser);

                // OrderDetail 리스트 순회
                selectUser.getOrderDetailList().forEach(detail -> {
                    System.out.println(detail);
                    // 각 OrderDetail에서 단일 Item 가져오기
                    Item item = detail.getItem();

                    if (item != null) {
                        // Item 정보 출력
                        System.out.println("Item ID: " + item.getId());
                        System.out.println("Item Name: " + item.getName());
                        System.out.println("Item Price: " + item.getPrice());
                    } else {
                        // Item이 null일 경우 메시지 출력
                        System.out.println("No item found for this order detail.");
                    }
                });
            });
        } else {
            System.out.println("No user1s found.");
        }
    }




    @Test
//    @Transactional
    public void update(){
        Optional<User1> user = userRepository.findById(2L);
        user.ifPresent(selectUser ->{//user가 값이 존재하면 실행된는 람다식
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");
            userRepository.save(selectUser);
            System.out.println(selectUser);
        });
    }

    @Test
//    @Transactional
    public void delete(){//삭제하고

        Optional<User1> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent());    // false
        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
            System.out.println(selectUser);
        });


        //Assertions.assertTrue(user.isPresent());는 user가 존재하는지 확인하는 JUnit 테스트 구문입니다.
        //여기서 isPresent()는 Optional이 비어 있지 않고 값이 있을 때 true를 반환합니다.
        //false라면 값이 비어 있다는 이야기이다.

        //user.ifPresent(selectUser->{
        //Optional 객체인 user가 값이 있을 때에만 실행되는 람다 표현식입니다.
        // ifPresent()는 user가 존재할 때 해당 사용자 객체를 selectUser로 받아 블록 안의 코드를 실행합니다.
    }

}
