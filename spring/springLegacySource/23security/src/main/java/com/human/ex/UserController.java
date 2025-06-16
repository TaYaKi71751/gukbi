package com.human.ex;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	

	@RequestMapping(value = "/user/user", method = RequestMethod.GET)
	public String user(Locale locale, Model model) {
		
		return "/user/user";
	}
	
	@RequestMapping(value = "/user/error", method = RequestMethod.GET)
	public String userError(Locale locale, Model model) {
		return "/user/error";
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String userLogin(Locale locale, Model model) {
		return "/user/login";
	}
}
