package com.example.start01.repository;

import com.example.start01.model.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User1,Long> {
    // select * from user where account = ? << test03, test04
    Optional<User1> findByAccount(String account);
    Optional<User1> findByEmail(String email);

    // select * from user where account = ? and email = ?
    Optional<User1> findByAccountAndEmail(String account, String email);
}
