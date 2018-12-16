package com.brat.sso.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@RequestMapping(value="/sample",method=RequestMethod.GET)
	public String sample(){
		return "sample";
	}

}
