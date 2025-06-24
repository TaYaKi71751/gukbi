package com.example.testsecurity.dto;

import com.example.testsecurity.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/*
자동으로 로그인 처리하려면 2클래스를 정의하면된다.
1.UserDetails클래스 , UserDetailsService

CustomUserDetails는 Spring Security의 UserDetails 인터페이스를 구현하여
사용자의 인증 정보를 저장하고 관리하는 역할을 수행합니다.
이 클래스는 UserEntity와 연동되어 사용자 정보를 기반으로 권한 및 인증 관련 데이터를 제공합니다.
*/
public class CustomUserDetails implements UserDetails {

    // 사용자 정보를 저장하는 UserEntity 객체
    private UserEntity userEntity;

    // 생성자: UserEntity 객체를 받아와 CustomUserDetails의 필드에 저장
    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        사용자의 권한 정보를 반환하는 메서드입니다.
        권한은 GrantedAuthority 인터페이스의 구현체로 표현됩니다.
        여기서는 UserEntity의 role 필드를 기반으로 권한을 생성합니다.
        */

        Collection<GrantedAuthority> collection = new ArrayList<>(); // 권한 정보를 저장할 컬렉션 생성

        // 익명 클래스를 사용하여 GrantedAuthority 구현
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                // 사용자 엔티티에서 역할 정보를 가져와 반환
                return userEntity.getRole();
            }
        });

        return collection; // 권한 정보 컬렉션 반환
    }

    @Override
    public String getPassword() {
        // 사용자의 비밀번호를 반환
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        // 사용자의 사용자명을 반환
        return userEntity.getUsername();
    }

    /*
    계정 상태를 확인하는 메서드들입니다.
    DB에 상태 정보를 저장하지 않는 경우 기본적으로 true를 반환하여 항상 유효한 계정으로 처리합니다.
    */

    @Override
    public boolean isAccountNonExpired() {
        // 계정이 만료되지 않았는지를 나타냄. 여기서는 항상 true 반환
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠기지 않았는지를 나타냄. 여기서는 항상 true 반환
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 사용자 자격 증명이 만료되지 않았는지를 나타냄. 여기서는 항상 true 반환
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정이 활성화 상태인지 나타냄. 여기서는 항상 true 반환
        return true;
    }
}
