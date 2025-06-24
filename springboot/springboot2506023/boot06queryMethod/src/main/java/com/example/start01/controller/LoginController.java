package com.example.start01.controller;

import com.example.start01.model.entity.LoginEntity;
import com.example.start01.model.request.LoginDto;
import com.example.start01.repository.LoginRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }
    @PostMapping("/insert")
    public String insert(LoginDto dto, Model model){
        LoginEntity entitySaved =loginRepository.save(dto.toEntity());
        System.out.println(entitySaved);
        return "redirect:selectAll";
    }

    @GetMapping("/selectAll")
    public String selectAll(Model model){
        ArrayList<LoginEntity> dtos=loginRepository.findAll();
        model.addAttribute("dtos",dtos);
        System.out.println(dtos);
        return "selectAll";
    }

    @GetMapping("/selectOne/{id}")
    public String selectOne(@PathVariable Integer id, Model model){
        LoginEntity entity=loginRepository.findById(id).orElse(null);
        model.addAttribute("entity",entity);
        return "selectOne";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes rttr){
        LoginEntity dto =loginRepository.findById(id).orElse(null);
        System.out.println(dto);
        if(dto!=null){
            loginRepository.delete(dto);
            rttr.addFlashAttribute("msg","success");
        }
        return "redirect:/selectAll";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id,
                         Model model){
        LoginEntity dto=loginRepository.findById(id).orElse(null);
        model.addAttribute("dto",dto);
        return "update";
    }
    @PostMapping("/update")
    public String update( LoginDto dto){
        LoginEntity entity=dto.toEntity();
        System.out.println(entity.toString());

        loginRepository.save(entity);

        return "redirect:/selectOne/"+entity.getId();
    }



    @GetMapping("/all")
    public String getAll(){
        //1 특정 ID로 로그인 정보를 검색하는 메서드 이미 존재
        Integer id=1;
        LoginEntity entity=loginRepository.findById(id).orElse(null);
        System.out.println("찾은 ID:"+ (entity));

        //2 이름으로 로그인 정보 검색  이름은 중복 가능하다.
        String name = "1";
        List<LoginEntity> loginsByName = loginRepository.findByName(name);
        System.out.println("이름으로 검색한 로그인 정보: " + loginsByName);

        String fixedText = "test";
        //3 이름에 특정 문자가 포함된 로그인 정보 검색
        List<LoginEntity> loginsContaining = loginRepository.findByNameContaining(fixedText);
        System.out.println("이름에 '" + fixedText + "'이 포함된 로그인 정보: " + loginsContaining);

        //4 이름이 특정 문자로 시작하는 로그인 정보 검색
        List<LoginEntity> loginsStartingWith = loginRepository.findByNameStartingWith(fixedText);
        System.out.println("이름이 '" + fixedText + "'로 시작하는 로그인 정보: " + loginsStartingWith);

        //5 이름이 특정 문자로 끝나는 로그인 정보 검색
        List<LoginEntity> loginsEndingWith = loginRepository.findByNameEndingWith(fixedText);
        System.out.println("이름이 '" + fixedText + "'로 끝나는 로그인 정보: " + loginsEndingWith);

        //6. ID와 비밀번호로 사용자 검색 (ID는 1, 비밀번호는 "1")
        id = 1;
        String password = "2";

        Optional<LoginEntity> login = loginRepository.findByIdAndPassword(id, password);
        if (login.isPresent()) {
            System.out.println("검색된 사용자: " + login.get());
        } else {
            System.out.println("사용자를 찾을 수 없습니다.");
        }
        //7. 특정 이름을 가진 사용자가 존재하는지 확인 (이름을 "test"로 고정)
       name = "test";

        boolean exists = loginRepository.existsByName(name);
        if (exists) {
            System.out.println("이름이 '" + name + "'인 사용자가 존재합니다.");
        } else {
            System.out.println("이름이 '" + name + "'인 사용자가 존재하지 않습니다.");
        }
        //8. ID가 주어진 값보다 큰 로그인 정보 검색 (고정값으로 1사용)
        id = 1;
        List<LoginEntity> logins = loginRepository.findByIdGreaterThan(id);
        System.out.println("ID가 " + id + "보다 큰 로그인 정보: " + logins);
        return "insert";
    }

    @GetMapping("/all2")
    public String getAll2() {

        //문제 1: 모든 로그인 정보의 수를 세는 메서드
        long count = loginRepository.countAll();
        System.out.println("모든 로그인 정보의 수: " + count); // 콘솔에 출력

        //문제 2: 모든 로그인 정보 검색
        List<LoginEntity> logins = loginRepository.findAllLogins();
        System.out.println("모든 로그인 정보: " + logins); // 콘솔에 출력

        //문제 3: 이름과 비밀번호로 로그인 정보 검색
        String name = "test";  // 임의로 설정한 name
        String password = "1";  // 임의로 설정한 password
        LoginEntity login = loginRepository.findByNameAndPassword(name, password);
        System.out.println("이름과 비밀번호로 검색된 로그인 정보: " + login); // 콘솔에 출력

        //문제 4: ID와 이름으로 로그인 정보가 존재하는지 확인
        name = "test";  // 임의로 설정한 name
        Integer id = 1;  // 임의로 설정한 id
        count = loginRepository.existsQuery(name, id);
        boolean exists = count > 0;
        System.out.println("ID와 이름으로 로그인 정보 존재 여부: " + exists); // 콘솔에 출력

        //문제 5: 이름으로 로그인 정보를 검색하고 정렬하기
        name = "test";  // 임의로 설정한 name
        logins = loginRepository.findByNameOrderByAsc(name);
        System.out.println("이름으로 검색한 로그인 정보 (오름차순): " + logins); // 콘솔에 출력

        //문제 6: 이름에 'test'가 포함된 사용자 정보를 검색하는 메서드
        String searchKeyword = "test";  // 임의로 설정한 searchKeyword
        logins = loginRepository.selectAllSQL(searchKeyword);
        System.out.println("이름에 '" + searchKeyword + "'가 포함된 로그인 정보: " + logins); // 콘솔에 출력








        return "insert";
    }

}









