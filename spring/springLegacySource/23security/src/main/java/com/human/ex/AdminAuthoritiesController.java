package com.human.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.dto.AuthoritiesDto;
import com.human.service.AuthoritiesService;

@Controller
public class AdminAuthoritiesController {
	
	@Autowired
	private AuthoritiesService service;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminAuthoritiesController.class);
	
	@RequestMapping(value = "/admin/authorities/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("dto") AuthoritiesDto dto) {
		return "/admin/authorities/update";
	}
	@RequestMapping(value = "/admin/authorities/update", method = RequestMethod.POST)
	public String updateDB(AuthoritiesDto dto) throws Exception{
		service.update(dto);
		return "redirect:/admin/authorities/selectAll";
	}
	
	@RequestMapping(value = "/admin/authorities/delete", method = RequestMethod.GET)
	public String delete(String username,RedirectAttributes rttr)throws Exception {
		service.delete(username);
		rttr.addFlashAttribute("msg","success");
		return "redirect:/admin/authorities/selectAll";
	}
	
	@RequestMapping(value = "/admin/authorities/selectName", method = RequestMethod.GET)
	public String selectName(String username, Model model) throws Exception {
		model.addAttribute("dto", service.selectName(username));
		return "/admin/authorities/selectName";
	}
	
	@RequestMapping(value = "/admin/authorities/selectAll", method = RequestMethod.GET)
	public String selectAll(Model model) throws Exception {
		model.addAttribute("list",service.selectAll());
		return "/admin/authorities/selectAll";
	}
	
	@RequestMapping(value = "/admin/authorities/insert", method = RequestMethod.GET)
	public String insert() {
		return "/admin/authorities/insert";
	}
	
	@RequestMapping(value = "/admin/authorities/insert", method = RequestMethod.POST)
	public String insertDB(AuthoritiesDto dto) throws Exception{
		service.insert(dto);
		return "redirect:/admin/authorities/selectAll";
	}
	
}