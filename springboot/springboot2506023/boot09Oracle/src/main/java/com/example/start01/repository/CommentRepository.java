package com.example.start01.repository;

import com.example.start01.model.entity.CommentEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CommentRepository extends CrudRepository<CommentEntity,Integer> {
    @Override
    ArrayList<CommentEntity> findAll();
    @Query(value="select * from comment_entity where login_entity_id=:loginEntityId",nativeQuery = true)
    ArrayList<CommentEntity> findByLoginEntityId(@Param("loginEntityId") Integer loginEntityId);
    ArrayList<CommentEntity> findByNameContaining(String name);



}
