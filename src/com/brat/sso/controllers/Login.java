package com.brat.sso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {
	
//	@Autowired
//	private UserPrivilege userPrivilege;
	
	@GetMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@GetMapping(value="/")
	@ResponseBody
	public String postLogin(){
		return "welcome "+"User";
	}
	
	@GetMapping(value="/lol")
	@ResponseBody
	public String lol(){
		return "Calling LOL";
	}
	
}
