package com.brat.sso.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Rest {

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/rest")
	public String getStatus(HttpServletRequest req, HttpServletResponse res) {
		JSONObject json = new JSONObject();
		json.put("status", HttpStatus.ACCEPTED);
		
		return json.toJSONString();
	}

}
