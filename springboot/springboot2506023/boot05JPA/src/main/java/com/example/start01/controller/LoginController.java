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

}
