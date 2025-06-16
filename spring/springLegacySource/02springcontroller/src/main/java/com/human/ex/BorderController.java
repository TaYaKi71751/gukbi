package com.human.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorderController {
	
	@RequestMapping("/board/view")
	public String view() {
		//로직
		return "board/view";
	}

}
