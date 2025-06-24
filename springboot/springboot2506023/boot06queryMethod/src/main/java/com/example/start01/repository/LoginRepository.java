package com.example.start01.repository;
//Repository 인터페이스는 Dao랑 같은 작업을 한다.
//이미 구현되어 있는 CrudRepository를 상속 받는다.
// <CRUD작업할entitiy클래스이름,테이블키의 자료형>
import com.example.start01.model.entity.LoginEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //쿼리 메소드(Query Method) 메소드 이름만으로 데이터베이스 쿼리를 자동 생성하고 실행하는 기능을 제공

    //기본문법
    // 접두사 + 조건 키워드 + 엔티티 필드 이름

    //1접두사
    //findBy   특정조건에 맞는 데이터를 조회  readBy,queryBy
    //countBy  조건에 맞는 레코드 수를 반환
    //deleteBy 조건에 맞는 데이터를 삭제
    //existsBy 조건에 맞는 데이터 존재여부를 반환

    //2.조건 키워드
    //And   여러 조건을 And로 결함
    //Or    여러 조건을 OR로 결함
    //Is/Equals     값이 같은지 비교
    //Between       범위검색
    //LessThan/GreaterThan      값비교
    //Like      % 부분일치 문자열검색
    //Containing    Like '%값%'
    //StartingWith    Like '값%'
    //EndingWith      Like '%값'
    //In            특정 값 목록에 포함여부
    //IsNull/IsNotNull
    //OrderBy       정렬조건

    //엔티티필드이름
    //엔티티 클래스에 정의된 필드이름과 동일해야 하고 CamelCase를 준수한다.

    //사용예
    //1. 단일조건
    // Optional<User> findById(Long id);
    // List<User>  findByName(String name);

    //2. 여러조건 조합
    //이름과 나이로 검색
    //List<User> findByNameAndAge(String name,int age);
    //이름 또는 이메일로 검색
    //List<User> findByNameOrEmail(String name,String email);

    //3. 비교 연산 및 범위 검색
    //나이가 특정 값 이상인 사용자 검색
    //List<User> findByAgeGreaterThan(int age);
    //특정 범위의 나이를 가진 사용자 검색
    //List<User> findByAgeBetween(int start,int end);

    //4. 패턴 매칭
    //이름에 특정 문자열이 포함된 사용자 검색
    //List<User> findByNameContaining(String keyword);
    //이메일이 특정값으로 시작하는 이메일 검색
    //List<User> findByEmailStarstingWith(String prefix);
    //이름이 특정 값으로 끝나는 사용자 검색
    //List<User> findByNameEndingWith(String suffix);

    //5 정렬
    // 이름으로 검색하고 결과를 나이순으로 정렬
    // List<User> findByNameOrderByAgeAsc(String name);
    //List<User>

    //6 존재 여부 확인
    // 특정 이메일이 존재하는지 확인
    //boolean existsByEmail(String email);

    //7 삭제 여부 확인
    // 이름이 특정 값인 사용자 삭제
    //void deleteByName(String name);


    //1 특정 ID로 로그인 정보를 검색하는 메서드 이미 존재
    Optional<LoginEntity> findById(Integer id);

    //2 이름으로 로그인 정보 검색  이름은 중복 가능하다.
    List<LoginEntity> findByName(String name);

    // 이름에 특정 문자가 포함된 로그인 정보 검색 (문자를 "test"로 고정)
    // 이름에 특정 문자로 시작하는 정보 검색 (문자를 "test"로 고정)
    // 이름에 특정 문자로 끝나는  로그인 정보 검색 (문자를 "test"로 고정)
    //3 이름에 특정 문자가 포함된 로그인 정보 검색
    List<LoginEntity> findByNameContaining(String name);
    //4 이름이 특정 문자로 시작하는 로그인 정보 검색
    List<LoginEntity> findByNameStartingWith(String name);
    //5 이름이 특정 문자로 끝나는 로그인 정보 검색
    List<LoginEntity> findByNameEndingWith(String name);



    //6. ID와 비밀번호로 사용자 검색 (ID는 1, 비밀번호는 "1")
    Optional<LoginEntity> findByIdAndPassword(Integer id, String password);
    //7. 특정 이름을 가진 사용자가 존재하는지 확인 (이름을 "test"로 고정)
    boolean existsByName(String name);
    //8. ID가 주어진 값보다 큰 로그인 정보 검색 (고정값으로 1사용)
    List<LoginEntity> findByIdGreaterThan(Integer id);



    //jpql 문법
    //https://kim-oriental.tistory.com/34
    //@Query 애노테이션을 사용해서 sql문과 유사하게 구문을 구성하는것

    // select [엔티티 또는 속성] from [엔티티] [별칭] where [조건]
    //@Query안에 :name은 외부에서 선언한 매개변수
    // @Query("select u from User u where u.name = :name")
    //select * from user where name="name"
    //List<User> findByName(@Param("name") String name);

    //order by
    //@Query("select u from User u Order by u.age desc")
    //select * from user order by age desc

    //group by 및 having
    //@Query("select u.city, count(u) from User u group by u.city having count(u)>5")
    //select city,count(*) from user group by city having count(*)>5

    //in
    //@Query("select u from User u where u.id in :ids)
    //List<User> findByIds(@Param("ids")List<Long> ids);
    //select * from user where id in (1,2,3)

    //like
    //@Query("select u from user u where u.name like :name")
    //List<User> findByNameLike(@Param("name") String name);


    // 모든 로그인 정보의 수를 세는 메서드
    @Query("SELECT count(l) FROM LoginEntity l")
    long countAll();
    // JPQL을 사용하여 모든 로그인 정보 검색
    @Query("SELECT l FROM LoginEntity l")
    List<LoginEntity> findAllLogins();

    // 이름과 비밀번호로 로그인 정보 검색
    @Query("SELECT l FROM LoginEntity l WHERE l.name = :name AND l.password = :password")
    LoginEntity findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    // ID와 이름으로 로그인 정보가 존재하는지 확인
    @Query("SELECT count(l.id) FROM LoginEntity l WHERE l.name = :name AND l.id = :id")
    int existsQuery(@Param("name") String name, @Param("id") Integer id);

    // 이름으로 로그인 정보를 검색하는 메서드
    @Query("SELECT l FROM LoginEntity l WHERE l.name = ?1 ORDER BY l.name ASC")
    List<LoginEntity> findByNameOrderByAsc(String name);




    // 이름에 test가 포함된 사람정보
    @Query(value = "SELECT * FROM login_entity l WHERE l.name LIKE %:searchKeyword%", nativeQuery = true)
    List<LoginEntity> selectAllSQL(@Param("searchKeyword") String searchKeyword);
}























