package com.example.start01.controller.rest;

import com.example.start01.model.entity.CommentEntity;
import com.example.start01.model.request.CommentDto;
import com.example.start01.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/rest/test")
    public String test() {
        return "helloRest";
    }

    //1.모든 데이터 검색
    @GetMapping("/rest/comment/selectAll")
    public ResponseEntity<List<CommentEntity>> selectAll() {
        List<CommentEntity> dtos = commentService.findAll();
        if (dtos == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //2. 특정 데이터 넣기
    @PostMapping("/rest/comment/insert")
    public ResponseEntity<CommentEntity> insert(@RequestBody CommentDto dto) {
        System.out.println(dto);
        CommentEntity saved = commentService.save(dto.toEntity());
        if (saved == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    //3.특정 댓글 1개 조회
    @GetMapping("/rest/comment/selectOne/{id}")
    public ResponseEntity<CommentEntity> selectOne(@PathVariable Integer id) {
        CommentEntity entity = commentService.findById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    //4.특정인에게 쓴 댓글들 조회
    @GetMapping("/rest/comment/selectSome/{loginEntityId}")
    public ResponseEntity<List<CommentEntity>> selectSome(@PathVariable Integer loginEntityId) {
        List<CommentEntity> dtos = commentService.findByLoginEntityId(loginEntityId);
        if (dtos == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //5.특정 댓글 수정
    @PutMapping("/rest/comment/update")
    public ResponseEntity<CommentEntity> update(@RequestBody CommentDto dto) {
        System.out.println(dto);
        CommentEntity saved = commentService.save(dto.toEntity());
        if (saved == null) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }
    //6.특정 댓글 삭제
    @DeleteMapping("/rest/comment/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        if(commentService.delete(id)==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

}

/*
    REST 주소가 곧 데이터
    데이터을 http 메서드를 통해서 CRUD작업을 하는것

    전송방식 get,post,put(patch),delete  각각의 전송방식에 따라서 CRUD작업이 결정된다.

    get select 읽기,조회  post insert 쓰기  put,patch 수정  delete 삭제

    restAPI설계  하나의 user테이블에 대한 설계
    1.사용자가 조회
    요청방식은 get이여야 하고  url   /api/users
    결과값
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com"
  },
  {
    "id": 2,
    "name": "Jane Doe",
    "email": "janedoe@example.com"
  }
]
    2. 사용자 상세조회
    요청방식은 get이여야 하고  url   /api/users/{id}
    결과값
  {
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com"
  }

  3.사용자 입력
  요청방식은 post  /api/users
  입력할 데이터처리는 body json형태로 한다.
  body에 추가한 데이터
  {
    "name": "John Doe",
    "email": "johndoe@example.com"
  }
  결과 값
 {
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com"
  }

  4.사용자 수정
  요청방식은 put /api/users
  body에 담아서 전송할 데이터
{
    "id": 1,   //수정할 id값
  "name": "John Smith",
  "email": "johnsmith@example.com"
}
응답:
{
    "id": 1
  "name": "John Smith",
  "email": "johnsmith@example.com"
}

    5.사용자 삭제 DELETE
    요청방식: delete   /api/users/{id}
    응답: 200ok

200 OK: 요청이 성공적으로 처리되었을 때 반환됩니다.
201 Created: POST 요청으로 자원이 생성되었을 때 반환됩니다.
400 Bad Request: 요청이 잘못되었을 때 반환됩니다.
404 Not Found: 요청한 자원을 찾을 수 없을 때 반환됩니다.
500 Internal Server Error: 서버에서 오류가 발생했을 때 반환됩니다.

 */
