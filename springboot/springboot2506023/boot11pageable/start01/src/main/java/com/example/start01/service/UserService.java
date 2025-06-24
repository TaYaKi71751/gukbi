package com.example.start01.service;

import com.example.start01.entity.UserEntity;
import com.example.start01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //나이가 특정값보다 큰 사용자 목록을 페이징 처리하여 조회
    public Page<UserEntity> getUserByAge(int age, Pageable pageable){
        return userRepository.findByAgeGreaterThan(age,pageable);
    }
}
