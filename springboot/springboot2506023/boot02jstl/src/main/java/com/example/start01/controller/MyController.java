package com.example.start01.controller;


import com.example.start01.dto.HumanDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class MyController {
    @GetMapping("/01model")
    public String model1(Model model){
        return "01model";
    }

    //ModelAndView사용하기
    @GetMapping("/02model")
    public ModelAndView model2(){
        log.info("02model");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("key","value=model2");
        modelAndView.setViewName("02model");
        return modelAndView;
    }

    //03model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("03model")
    public String model3(
            @RequestParam("name") String name,
            @RequestParam("age") long age, // `long` 타입으로 수정
            @RequestParam("height") double height, // 추가된 필드
            @RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
            LocalDateTime birthday,
            Model model) {
        log.info("03model");
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("height : " + height);
        System.out.println("birthday : " + birthday);

        return "03model";
    }



    //04model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("04model")
    public String model4(@ModelAttribute HumanDto humanDto, Model model) {
        log.info("04model");
        System.out.println("name : " + humanDto.getName());
        System.out.println("age : " + humanDto.getAge());
        System.out.println("height : " + humanDto.getHeight());
        System.out.println("birthday : " + humanDto.getBirthday());

        return "04model";
    }

    //05model?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("05model")
    public String model5(@ModelAttribute HumanDto humanDto, Model model) {
        log.info("05model");


        // 기존 Map 생성 및 데이터 추가
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "홍길동");
        map.put("key2", "21");
        map.put("key3", "대전");

        // HumanDto 객체를 key4로 추가
        map.put("key4", humanDto);

        // Map을 Model에 추가
        model.addAttribute("mapdata", map);

        return "05model";
    }

    @GetMapping("/06model")
    public String model6(Model model){
        List<HumanDto> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            HumanDto dto=new HumanDto();
            dto.setName("이름"+i);
            dto.setAge(25+i);
            dto.setHeight(179+i);
            dto.setBirthday(LocalDateTime.of(1993,7,21,10,30).plusYears(i));
            list.add(dto);
        }
        model.addAttribute("list",list);
        return "06model";
    }
    @GetMapping("/07model")
    public String model7(Model model){
        log.info("여러가지 문자열 출력");
        model.addAttribute("msgStr","success");
        model.addAttribute("tagStr","<h1>tag</h1>");
        return "07model";
    }

    @GetMapping("/08model")
    public String model8(Model model){
        log.info("다양한 제어문");
        model.addAttribute("name","홍길동");
        model.addAttribute("age",20);


        List<HumanDto> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            HumanDto dto=new HumanDto();
            dto.setName("이름"+i);
            dto.setAge(25+i);
            dto.setHeight(179+i);
            dto.setBirthday(LocalDateTime.of(1993,7,21,10,30).plusYears(i));
            list.add(dto);
        }
        model.addAttribute("list",list);


        return "08model";
    }


}
