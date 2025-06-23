package com.example.start01.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.start01.dto.HumanDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MyController {
    @GetMapping("/sum")
    public String sum(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a + b);
        return "sum";
    }

    @GetMapping("/sub")
    public String sub(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a - b);
        return "sub";
    }

    @GetMapping("/mul")
    public String mul(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a * b);
        return "mul";
    }

    @GetMapping("/div")
    public String div(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a / b);
        return "div";
    }

    @GetMapping("/model2")
    public ModelAndView model2() {
        ModelAndView modelAndView = new ModelAndView("model2");
        modelAndView.addObject("key", "value=model2");
        modelAndView.setViewName("model2");
        return modelAndView;
    }

    @GetMapping("/model3")
    public String model3(Model model) {
        Map<String, String> rMap = new HashMap<>();
        rMap.put("key1", "홍길동");
        rMap.put("key2", "21");
        rMap.put("key3", "서울");
        model.addAttribute("mapData", rMap);

        HumanDto humanDto = new HumanDto();
        humanDto.setAge(21l);
        humanDto.setName("홍길동");
        humanDto.setHeight(175.5);
        humanDto.setBirthday(LocalDateTime.of(1993, 7, 21, 10, 30));
        model.addAttribute("humanDto", humanDto);
        model.addAttribute("message", "success");
        model.addAttribute("title", "<h1>제목</h1>");
        return "model3";
    }

    @GetMapping("/model4")
    public String thymeleafControl(Model model) {
        model.addAttribute("title", "이 문자열은 제목");
        model.addAttribute("age", 20);

        List<HumanDto> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HumanDto dto = new HumanDto();
            dto.setName("name" + i);
            dto.setAge(25 + i);
            dto.setHeight(170 + i);
            dto.setBirthday(LocalDateTime.of(1993, 7, 21, 10, 30).plusYears(i)); // Set example birthday
            list.add(dto);
        }
        model.addAttribute("list", list);

        return "model4";
    }

    // model5?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("model5")
    public String noneDtoSend(
            @RequestParam("name") String name,
            @RequestParam("age") long age, // `long` 타입으로 수정
            @RequestParam("height") double height, // 추가된 필드
            @RequestParam("birthday") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime birthday,
            Model model) {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("height : " + height);
        System.out.println("birthday : " + birthday);

        model.addAttribute("result", "none dto send OK");
        return "model5";
    }
    //model6?name=John&age=25&height=175.5&birthday=2023-09-11T15:30
    @GetMapping("/model6")
    public String dtoSend(@ModelAttribute HumanDto humanDto, Model model) {
        System.out.println("name : " + humanDto.getName());
        System.out.println("age : " + humanDto.getAge());
        System.out.println("height : " + humanDto.getHeight());
        System.out.println("birthday : " + humanDto.getBirthday());

        model.addAttribute("result", "dto send OK");
        return "model6";
    }

}