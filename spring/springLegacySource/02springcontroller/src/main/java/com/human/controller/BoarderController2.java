package com.human.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoarderController2 {
	@RequestMapping("/view2")
	public String view2() {
		return "board/view";
	}
	
	@RequestMapping("/view3")
	public String view3(Model model) {
		model.addAttribute("id","hello");
		return "board/view3";
	}
	
	@RequestMapping("/view4")
	public ModelAndView view4() {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("id","hello2");
		
		mv.setViewName("board/view3");
		
		return mv;
	}

}




