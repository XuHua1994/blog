package com.fastech.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginViewController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}
	
	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
	public String loginout() {
		return "loginout";
	}

}
