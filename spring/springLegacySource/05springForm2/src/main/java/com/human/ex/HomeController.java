package com.human.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.dto.HumanDto;

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
	
	
	//http://localhost:8082/ex/board/form1?id=hi&pw=1234
		@RequestMapping(value = "/board/form1", method = RequestMethod.GET)
		public String form1(@RequestParam("id") String id,
				@RequestParam("pw") int pw,Model model) {
//			String id=request.getParameter("id");
//			String pw=request.getParameter("pw");
			model.addAttribute("id",id);
			model.addAttribute("pw",pw);	
		
			//추가적으로 name과 age를 추가해 보자.
			//입력 화면 만들들어 form태그에서 사용자 입력을 만들어 보자.
			
			
			return "board/form1";
		}
		
		//http://localhost:8082/ex/board/form2?myid=hi&mypw=1234
		@RequestMapping(value = "/board/form2", method = RequestMethod.GET)
		public String form2(@RequestParam("myid") String id,
				@RequestParam("mypw") int pw,Model model) {

			model.addAttribute("id",id);
			model.addAttribute("pw",pw);	

			return "board/form1";
		}
		
		
		//http://localhost:8082/ex/board/form3?id=hi&pw=1234
		@RequestMapping(value = "/board/form3", method = RequestMethod.GET)
		public String form3(String id,int pw,Model model) {

			model.addAttribute("id",id);
			model.addAttribute("pw",pw);	
			
			return "board/form1";
		}
		
		//http://localhost:8082/ex/board/form4?id=hi&pw=1234&name=park&age=21
		@RequestMapping(value = "/board/form4", method = RequestMethod.GET)
		public String form4(HumanDto humanDto) {
			//매개변수에서 getter,setter가 포함된 클래스를 넣으면
			//request작업과 model작업을 하지 않아도 model에 받은 데이터가 세팅된다.
			//model에 담긴 이름은 humanDto가 된다.
			//el에서 사용하는 humanDto는 클래스이름 HumanDto에 첫자를 소문자로 바꾼것이다.
			
			
			return "board/form4";
		}
		
		//http://localhost:8082/ex/board/form5?id=hi&pw=1234&name=park&age=21
		@RequestMapping(value = "/board/form5", method = RequestMethod.GET)
		public String form5(@ModelAttribute("newHuman") HumanDto humanDto) {
			
			//el에서 사용하는 humanDto는 클래스이름 HumanDto에 첫자를 소문자로 바꾼것이다.
			//humanDto @ModelAttribute를 사용하면된다.
			
			
			return "board/form4";
		}
		
		//http://localhost:8082/ex/board/10
		//http://localhost:8082/ex/board/12
		//http://localhost:8082/ex/board/15		
		@RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET)
		public String form6(@PathVariable String boardId,Model model) {
			
			model.addAttribute("boardId",boardId);
			
			
			return "board/form6";
		}
		
		//cheakbox 
		//http://localhost:8082/ex/board/form7?names=10&names=20
		@RequestMapping(value = "/board/form7", method = RequestMethod.GET)
		public String form7(String[] names,Model model) {
			
			
			model.addAttribute("names",names);
			
			
			return "board/form7";
		}
		
		
		
}
