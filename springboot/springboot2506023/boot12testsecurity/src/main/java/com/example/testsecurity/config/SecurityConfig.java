package com.example.testsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration // 이 클래스가 Spring Configuration 클래스임을 선언
@EnableWebSecurity // Spring Security를 활성화하기 위한 어노테이션
public class SecurityConfig {

    @Bean // 이 메서드는 Spring IoC 컨테이너에 빈을 등록
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        // 비밀번호 인코더를 BCrypt 방식으로 설정하여 안전하게 비밀번호를 처리
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // SecurityFilterChain을 정의하여 HTTP 요청에 대한 보안 설정을 커스터마이징

        http
                .authorizeHttpRequests(auth -> auth // 요청에 대한 접근 권한 설정
                        // /, /login, /loginProc, /h2-console, /static/** 경로는 모든 사용자에게 허용
                        .requestMatchers("/", "/login", "/loginProc", "/h2-console/**", "/static/**").permitAll()
                        .requestMatchers("/join", "/joinProc").permitAll() // /join, /joinProc 경로도 모든 사용자에게 허용
                        .requestMatchers("/admin").hasRole("ADMIN") // /admin 경로는 ADMIN 역할을 가진 사용자만 접근 가능
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER") // /my/** 경로는 ADMIN 또는 USER 역할을 가진 사용자만 접근 가능
                        .anyRequest().authenticated() // 위 조건에 맞지 않는 모든 요청은 인증이 필요
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")) // H2 콘솔에서는 CSRF 보호를 비활성화
                // X-Frame-Options 헤더를 SAMEORIGIN으로 설정하여 클릭재킹 공격을 방지
                .headers(headers -> headers
                        .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                );
        http
                .formLogin((auth) -> auth // 폼 로그인 설정
                        .loginPage("/login") // 로그인 페이지를 /login 경로로 설정
                        .loginProcessingUrl("/loginProc") // 로그인 폼이 제출될 URL을 /loginProc으로 설정
                        .permitAll()); // 로그인 페이지와 로그인 처리 URL은 모두 인증 없이 접근 가능

//        http
//                .csrf((auth) -> auth.disable()); // 이 코드가 활성화되면 전체 CSRF 보호를 비활성화 (현재 주석 처리됨)

        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1) // 한 사용자당 최대 세션 수를 1로 설정
                        .maxSessionsPreventsLogin(true)); // 세션이 1개를 초과하면 새로운 로그인 시도를 방지

        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId()); // 세션 고정 공격을 방지하기 위해 로그인 시 세션 ID를 변경

        http
                .logout((auth) -> auth // 로그아웃 설정
                        .logoutUrl("/logout") // 로그아웃 처리 URL을 /logout으로 설정
                        .logoutSuccessUrl("/")); // 로그아웃 성공 후 리디렉션될 URL을 /로 설정

        return http.build(); // SecurityFilterChain 설정을 반환하여 적용
    }
}







