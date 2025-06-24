package com.example.start01.controller;

import com.example.start01.dto.HumanDto;
import com.example.start01.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HumanController {
    @Autowired
    private HumanService humanService;


//       <td><a th:href="@{/delete(name=${dto.name})}">삭제</a></td>
    @GetMapping("/delete")
    public String humanDelete(String name){
        humanService.humanDelete(name);
        return "redirect:selectAll";
    }

    @GetMapping("/insert")
    public String humanInsert(){
        return "insert";
    }

    @PostMapping("/insert")
    public String humanInsert(@ModelAttribute HumanDto humanDto){
        humanService.humanInsert(humanDto);
        return "redirect:selectAll";
    }

    @GetMapping(value = "/selectAll")
    public String selectAll( Model model) throws Exception{
        ArrayList<HumanDto> dtos=humanService.selectAll();
        for(HumanDto dto:dtos) {
            System.out.println(dto);
        }
        model.addAttribute("list", dtos);
        return "selectAll";
    }

    @GetMapping(value = "/selectName")
    public String selectName(String name,Model model) throws Exception{
        System.out.println("name:"+name);
        HumanDto dto=humanService.humanSelectName(name);
        model.addAttribute("dto", dto);
        return "selectName";
    }
    @GetMapping(value = "/update")
    public String update(HumanDto humanDto,Model model) throws Exception{
        System.out.println(humanDto);
        return "update";
    }

    @PostMapping(value="/update")
    public String updateDB(HumanDto humanDto,Model model) throws Exception {
        System.out.println("update:"+humanDto);
        //db
        humanService.humanUpdate(humanDto);
        return "redirect:selectAll";

    }


}
