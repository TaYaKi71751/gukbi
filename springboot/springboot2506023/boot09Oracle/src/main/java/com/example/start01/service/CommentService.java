package com.example.start01.service;

import com.example.start01.model.entity.CommentEntity;
import com.example.start01.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //저장 수정
    public CommentEntity save(CommentEntity dto){
        CommentEntity save=commentRepository.save(dto);
        return save;
    }
    //모든 데이터 검색
    public ArrayList<CommentEntity> findAll(){
        return commentRepository.findAll();
    }

    //id로 코멘트 검색
    public CommentEntity findById(Integer id){
        return commentRepository.findById(id).orElse(null);
    }

    //id로 삭제 삭제후 삭제한 데이터 정보리턴
    public CommentEntity delete(Integer id){
        CommentEntity entity = commentRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        commentRepository.delete(entity);
        return entity;
    }

    //특정 사용자의 id로 답글 검색
    public ArrayList<CommentEntity> findByLoginEntityId(Integer id){
        return commentRepository.findByLoginEntityId(id);
    }

    //특정아이디에 답글단 사람으로 검색
    public ArrayList<CommentEntity> findByNameContaining(String hello) {
        return commentRepository.findByNameContaining(hello);
    }
}
