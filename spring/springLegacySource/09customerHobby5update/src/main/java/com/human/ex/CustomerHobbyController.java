package com.human.ex;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;
import com.human.dto.HobbyDto;
//import com.human.service.ICustomerHobbyService;
import com.human.service.ICustomerHobbyService;
import com.human.service.ICustomerService;
import com.human.service.IHobbyService;

/**
 * 고객관련 Update추가
 * customerHobby/updateCustomer?id=20
 * 하비관련 Update추가
 * customerHobby/updateHobby?id=20&hobby=야구
 * 
 * 
 * -- dept,emp join 결과출력
 * -- dept,emp join 테이블 입력작업
 * 
 * -- 장바구니 jsp ->spring 변경
 * 
 * 삭제 방법
 * 1. 고객을 통해서 지우면 고객이 보유한 하비를 모두 삭제한다음에 고객을 삭제해야 한다.
 * customerHobby/deleteCustomer?id=20
 * 2. 하비를 통해서 지우면 하비를 소유한 고객아이디와 하비이름으로 하비만 삭제해야 한다.
 * customerHobby/deleteHobby?id=20&hobby=야구
 */
@Controller
public class CustomerHobbyController {
	
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IHobbyService hobbyService;
	
	@Autowired
	private ICustomerHobbyService customerHobbyService;
	private static final Logger logger = LoggerFactory.getLogger(CustomerHobbyController.class);
	
//	@Autowired
//	private IHobbyService hobbyService;
	//customerHobby/updateHobby?id=20&hobby=야구
	@RequestMapping(value = "/customerHobby/updateHobby", method = RequestMethod.GET)
	public String updateHobby(Integer id,Model model,HobbyDto dto) throws Exception{
		System.out.println("updateHobby");
		model.addAttribute(hobbyService.select(dto));
		return "/customerHobby/updateHobby";
	}
	@RequestMapping(value = "/customerHobby/updateHobby", method = RequestMethod.POST)
	public String updateHobbyDB(HobbyDto dto,RedirectAttributes rttr,Model model) throws Exception{
		System.out.println("/customerHobby/updateHobby  post");
		hobbyService.update(dto);
		rttr.addFlashAttribute("msg","success");
		return "redirect:/customerHobby/selectAll";
	}
	
	
	//customerHobby/updateCustomer?id=20
	@RequestMapping(value = "/customerHobby/updateCustomer", method = RequestMethod.GET)
	public String updateCustomer(Integer id,Model model) throws Exception{
		System.out.println("updateCustomer");
		model.addAttribute(customerService.select(id));
		return "/customerHobby/updateCustomer";
	}
	@RequestMapping(value = "/customerHobby/updateCustomer", method = RequestMethod.POST)
	public String updateCustomerDB(CustomerDto dto,RedirectAttributes rttr,Model model) throws Exception{
		System.out.println("updateCustomerDB");
		customerService.update(dto);
		rttr.addFlashAttribute("msg","success");
		return "redirect:/customerHobby/selectAll";
	}
	

	
	//customerHobby/deleteCustomer?id=20
	@RequestMapping(value = "/customerHobby/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(Integer id,Model model) throws Exception{
		System.out.println("deleteCustomer");
		// 하비테이블에 id에 해당하는 취미 삭제
		// 고객테이블에 id에 해당하는 취미 삭제
		customerHobbyService.deleteCustom(id);
		return "redirect:/customerHobby/selectAll";
	}
	//customerHobby/deleteHobby?id=20&hobby=야구
	@RequestMapping(value = "/customerHobby/deleteHobby", method = RequestMethod.GET)
	public String deleteHobby(String hobby,Integer id,Model model) throws Exception{
		System.out.println("/customerHobby/deleteHobby");
		//하비테이블에 id,hobby로 원하는 hobby데이터를 지우는 작업
		customerHobbyService.deleteHobby(id, hobby);
		return "redirect:/customerHobby/selectAll";
	}

	@RequestMapping(value = "/customerHobby/selectAll", method = RequestMethod.GET)
	public String home( Model model) throws Exception {
		//두테이블을 조인하는 customerHobbyService제작
		List<CustomerHobbyDto> dtos= customerHobbyService.selectAll();
		for(CustomerHobbyDto dto:dtos) {
			System.out.println(dto);
		}
		model.addAttribute("list",dtos);
		return "customerHobby/selectAll";
	}
		
//		1. 테이블확인
//		2. CustomerHobbyDto생성
//		3. ICustomerDao에 조인메소드 추가 	selectAllCustomerHobby()
//		4.customerMapper.xml에 sql추가
//		5.service생성
//		6.컨트롤러에서 service를 이용해서 조인결과를 model에 담는다.
//		7.조인결과를 화면에 출력하는 view를 만든다.
		
		//dept, emp테이블 조인결과를 출력하는 프로그램
		
		

		@RequestMapping(value = "/customerHobby/insert", method = RequestMethod.GET)
		public String insert(Model model) throws Exception{
//			System.out.println("customHobby");
//			System.out.println("insert GUI");
			return "customerHobby/insert";
		}
		
		@RequestMapping(value = "/customerHobby/insert", method = RequestMethod.POST)
		public String insertData(CustomerDto dto,String[] hobbys
				,RedirectAttributes rttr) throws Exception{
			System.out.println("insert db"+hobbys);
			ArrayList<String> hobbysArr =new ArrayList<String>();
			for(String hobby:hobbys) {
				hobbysArr.add(hobby);
			}
				
			customerHobbyService.insertCustomHobby(dto, hobbysArr);
			
			//customerService.insert(dto);
			//hobbyService.insert(dto);
			//rttr.addFlashAttribute("msg","success");
			return "redirect:/customerHobby/selectAll";
		}
}
