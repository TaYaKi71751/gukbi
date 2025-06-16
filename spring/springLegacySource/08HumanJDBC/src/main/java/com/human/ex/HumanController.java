package com.human.ex;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.dto.HumanDto;
import com.human.service.IHumanService;

@Controller
public class HumanController {
	
	@Autowired
	private IHumanService service;
	//1. 수정화면  update  get
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HumanDto humanDto) throws Exception {
		
		return "update";
	}
	//2. 수정 DB작업 update post
	//update?name=홍길삼&age=23&height=152.3&birthday=2024-07-02T16:31
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDB(HumanDto humanDto,RedirectAttributes rttr) throws Exception {
		service.update(humanDto);
		
		rttr.addFlashAttribute("msg","success");
		return "redirect:/selectAll";
	}
	
	// delete?name=홍길도
	// 이름으로 데이터 삭제

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String name,RedirectAttributes rttr) throws Exception {
		
		service.delete(name);
		rttr.addFlashAttribute("msg","success");
		return "redirect:/selectAll";
	}
	
	@RequestMapping(value = "/selectName", method = RequestMethod.GET)
	public String selectName(String name, Model model) throws Exception {
		HumanDto humanDto = service.selectName(name);
		model.addAttribute("dto",humanDto);
		return "selectName";
	}
	
	
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public String selectAll( Model model) throws Exception {
		ArrayList<HumanDto> dtos=service.selectAll();
		model.addAttribute("list", dtos);
		//model.addAttribute("msg", "success"); 있으면 성공메시지 없으면 성공메시지가 안뜸
		return "selectAll";
	}
	

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert( Model model) throws Exception {
		return "insert";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertDB(HumanDto humanDto,RedirectAttributes rttr) throws Exception {
		
		service.insert(humanDto);
		rttr.addFlashAttribute("msg","success");
		
		
		return "redirect:/selectAll";
	}

	
//	어려우신분은 HUMAN데이터베이스 CRUD
//	작업을 한번더 해보고 작업하자.
//
//	c##scott/tiger
//	deptno  <--프로그램 CRUD작업 해보기

}
