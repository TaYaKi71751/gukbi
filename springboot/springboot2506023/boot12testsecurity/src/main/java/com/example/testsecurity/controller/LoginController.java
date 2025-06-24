package com.example.testsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginP(){
        return "login";
    }


    @GetMapping("/logout") // "/logout" 경로에 대한 GET 요청을 처리
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 현재 사용자의 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // 인증 정보가 존재하면 SecurityContextLogoutHandler를 통해 로그아웃 처리
            // 세션을 무효화하고 SecurityContext를 비우며, 추가적인 로그아웃 작업 수행
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        // 로그아웃 후 홈 페이지("/")로 리디렉션
        return "redirect:/";
    }
}
