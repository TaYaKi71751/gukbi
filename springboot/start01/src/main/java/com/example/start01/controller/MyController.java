package com.example.start01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;


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
        return "model3";
    }
}