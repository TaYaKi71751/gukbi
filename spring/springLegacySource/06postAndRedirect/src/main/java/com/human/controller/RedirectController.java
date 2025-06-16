package com.human.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
	//사용자에게 id를 입력받아 id가 hi이면 ok.jsp hi가 아니면 fail.jsp로 이동하는 프로그램
	@RequestMapping(value = "/redirect/input", method = RequestMethod.GET)
	public String redirectInput(Model model) {
		return "redirect/input";
	}
	@RequestMapping(value = "/redirect/result", method = RequestMethod.GET)
	public String redirectResult(String id,Model model) {
		if(id.equals("hi")) {
			//로그인 성공
			return "redirect:/redirect/ok";
		}
		//로그인 실패
		return "redirect:/redirect/fail";
	}
	
	@RequestMapping(value = "/redirect/ok", method = RequestMethod.GET)
	public String redirectOk(Model model) {
		return "redirect/ok";
	}
	@RequestMapping(value = "/redirect/fail", method = RequestMethod.GET)
	public String redirectFail(Model model) {
		return "redirect/fail";
	}
	
	//project07 만들어서  사용자 입력을 get,post로 처리해서 
	//화면에 보여주는 프로그램을 만들어 보자.
	//"사용자 입력" 검색해서 3번 페이지 957번
	
	
	//한글 페이지, 영문페이지를 입력받아  해당 언오로 되어 있는 페이지로 
	//이동하는 프로그램을 구현해 보자.

}

