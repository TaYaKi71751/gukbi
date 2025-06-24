package com.example.start01.repository;

import com.example.start01.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

//@DataJpaTest                                                                    // JPA 테스트 관련 컴포넌트만 Import
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@SpringBootTest
@DisplayName("ItemRepositoryTest 테스트")
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create1(){

        Item item = new Item();
        item.setName("노트북1");
        item.setPrice(100000);
        item.setContent("삼성 노트북1");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
        System.out.println(newItem);
    }
    @Test
    public void create2(){

        Item item = new Item();
        item.setName("노트북2");
        item.setPrice(100000);
        item.setContent("삼성 노트북2");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
        System.out.println(newItem);
    }
    @Test
    public void create3(){

        Item item = new Item();
        item.setName("노트북3");
        item.setPrice(100000);
        item.setContent("삼성 노트북3");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
        System.out.println(newItem);
    }
    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);
        Assertions.assertTrue(item.isPresent());
        System.out.println(item);
    }
}
