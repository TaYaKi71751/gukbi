package com.example.start01.controller;

import com.example.start01.entity.UserEntity;
import com.example.start01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //주소에 매개변수가 없으면 에러남
// //http://localhost:8081/users?age=25&page=0&size=10
    @GetMapping("/users")
    public String getUsers(@PageableDefault(size=5,sort="name",direction = Sort.Direction.DESC)Pageable pageable
    , @RequestParam int age, @RequestParam int page, @RequestParam int size, Model model){

        //기본값으로 생성하지 않고 변경한 값으로 사용하려면
        pageable = PageRequest.of(page,size,Sort.by("name").descending());

        //서비스에서 페이징 처리된 사용자 목록을 가져옴
        Page<UserEntity> userPage =userService.getUserByAge(age,pageable);

        //페이징된 데이터
        model.addAttribute("users",userPage.getContent());
        //총 페이지수
        model.addAttribute("totalPages",userPage.getTotalPages());

        //현재 페이지 번호
        model.addAttribute("currentPage",userPage.getNumber());

        //한페이지에 몇개의 데이터를 가져왔나
        model.addAttribute("size",userPage.getSize());

        model.addAttribute("age",age);
        return "userList";
    }
}
