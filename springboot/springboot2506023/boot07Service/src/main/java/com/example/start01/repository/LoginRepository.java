package com.example.start01.repository;
//Repository 인터페이스는 Dao랑 같은 작업을 한다.
//이미 구현되어 있는 CrudRepository를 상속 받는다.
// <CRUD작업할entitiy클래스이름,테이블키의 자료형>
import com.example.start01.model.entity.LoginEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
//메서드 시그니처(Method Signature)는 특정 메서드를 고유하게 식별하기 위해 사용되는 메서드
//메서드 시그니처 약속된 메소드
//    메서드 시그니처(Method Signature)"라고 부릅니다. 메서드 시그니처는 메서드의 이름,
//    리턴 타입, 매개변수 목록을 포함하며, 메서드를 구분하는 중요한 요소입니다.
//    이 예시에서는 findAll() 메서드가 ArrayList<LoginEntity> 타입을 반환하는 것으로 재정의(override)되고 있습니다.
//    기본적으로 CrudRepository에서 제공하는 findAll() 메서드는 Iterable<LoginEntity>를 반환하는데,
//    이를 ArrayList<LoginEntity>로 변경한 것입니다.
public interface LoginRepository extends CrudRepository<LoginEntity,Integer> {
    @Override
    ArrayList<LoginEntity> findAll();
}
