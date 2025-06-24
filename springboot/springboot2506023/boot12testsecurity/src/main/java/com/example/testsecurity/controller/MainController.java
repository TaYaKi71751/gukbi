package com.example.testsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller // 이 클래스가 Spring MVC 컨트롤러임을 나타냄
public class MainController {

    @GetMapping("/") // "/" 경로에 대한 GET 요청을 처리
    public String mainP(Model model) {
        // 현재 인증된 사용자의 ID(Username)를 가져옴
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        // 현재 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증된 사용자의 권한 정보를 가져옴
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 권한 정보를 순회할 Iterator 생성
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        // 첫 번째 권한을 가져옴
        GrantedAuthority auth = iter.next();
        // 권한의 이름(예: ROLE_USER, ROLE_ADMIN)을 가져옴
        String role = auth.getAuthority();

        // 인증된 사용자 ID를 모델에 추가하여 뷰에 전달
        model.addAttribute("id", id);
        // 인증된 사용자의 권한 정보를 모델에 추가하여 뷰에 전달
        model.addAttribute("role", role);

        // main.html 또는 main.jsp 등 뷰 리졸버에서 처리될 템플릿 파일 이름을 반환
        return "main";
    }
}
