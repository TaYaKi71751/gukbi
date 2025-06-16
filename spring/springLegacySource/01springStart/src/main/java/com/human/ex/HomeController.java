package com.human.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public String home2(Model model) {
		model.addAttribute("myString","hello world");
		
		return "home2";
	}
	//  /helloworld라는 주소로 들어가서 model에 str1 에는 hello str2에는 world 문자열을 담고
	// 화면에 str1과 str2를 이용해서 hello world를 출력해 보자.
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String home3(Model model) {
		model.addAttribute("str1","hello");
		model.addAttribute("str2","world");
		
		return "home3";
	}
	
	//profile에 들어와서 본인정보를 모델에 담아 화면에 출력해보자.
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String home4(Model model) {
		model.addAttribute("name","홍길동");
		model.addAttribute("age","18");
		
		return "profile";
	}
	
	
//	
//	@RequestMapping(value = "/my", method = RequestMethod.GET)
//	public String home2(Model model) {
//		model.addAttribute("myString", "helloWorld");
//		return "home2";
//	}	
}
