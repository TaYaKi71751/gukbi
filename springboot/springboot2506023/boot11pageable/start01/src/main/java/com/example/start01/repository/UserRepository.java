package com.example.start01.repository;

import com.example.start01.entity.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    //나이가 특정값보다 큰 사용자 목록을 페이징 처리하여 조회
    //page객체를 사용하고 싶으면  매개변수에 Pageable 리턴값을 Page<리턴될데이터>
    Page<UserEntity> findByAgeGreaterThan(int age, Pageable pageable);//부분읽어오기
//    ArryList<UserEntity> findByAgeGreaterThan(int age);  전체 읽어오기
}
