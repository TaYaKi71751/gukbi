package com.example.start01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @RequestMapping("/sum")
    public String sum(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a + b);
        return "sum";
    }

    @RequestMapping("/sub")
    public String sub(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a - b);
        return "sub";
    }

    @RequestMapping("/mul")
    public String mul(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a * b);
        return "mul";
    }

    @RequestMapping("/div")
    public String div(@RequestParam Double a, @RequestParam Double b, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", a / b);
        return "div";
    }
}