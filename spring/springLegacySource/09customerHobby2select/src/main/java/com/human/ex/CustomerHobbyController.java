package com.human.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.dto.CustomerHobbyDto;
//import com.human.service.ICustomerHobbyService;
import com.human.service.ICustomerHobbyService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerHobbyController {
	
	@Autowired
	private ICustomerHobbyService customerHobbyService;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerHobbyController.class);
	

	@RequestMapping(value = "/customerHobby/selectAll", method = RequestMethod.GET)
	public String home( Model model) throws Exception {
		//두테이블을 조인하는 customerHobbyService제작
		List<CustomerHobbyDto> dtos= customerHobbyService.selectAll();
		for(CustomerHobbyDto dto:dtos) {
			System.out.println(dto);
		}
		model.addAttribute("list",dtos);
		return "customerHobby/selectAll";
		
//		1. 테이블확인
//		2. CustomerHobbyDto생성
//		3. ICustomerDao에 조인메소드 추가 	selectAllCustomerHobby()
//		4.customerMapper.xml에 sql추가
//		5.service생성
//		6.컨트롤러에서 service를 이용해서 조인결과를 model에 담는다.
//		7.조인결과를 화면에 출력하는 view를 만든다.
		
		//dept, emp테이블 조인결과를 출력하는 프로그램
		
	}

}
