package com.sdorilas.tracer.tracerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	@GetMapping("/")
	public String home() {
		return "_base-jsps/index.jsp";
	}
	
	@GetMapping("/Login")
	public String login() {
		return "_base-jsps/login.jsp";
	}
	
	@GetMapping("/Logout")
	public String logout() {
		return "_base-jsps/login.jsp?logout=true";
	}
}
