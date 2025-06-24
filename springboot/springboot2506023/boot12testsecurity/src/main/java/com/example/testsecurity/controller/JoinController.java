package com.example.testsecurity.controller;

import com.example.testsecurity.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.testsecurity.dto.JoinDto;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String join1(){
        return "join";
    }
    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDto){

        System.out.println(joinDto.getUsername());

        joinService.joinProcess(joinDto);

        return "redirect:/login";
    }




}
