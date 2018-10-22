package com.sdorilas.tracer.tracerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sdorilas.tracer.tracerapp.dto.Mail;
import com.sdorilas.tracer.tracerapp.services.EmailService;

@Controller
public class BaseController {
	
	@Autowired
    private EmailService emailService;
	
	@GetMapping("/")
	public String home() {
		System.out.println("///////////////////////////////////////////mail");
//Test
//        Mail mail = new Mail();
//        mail.setFrom("tracer.com");
//        mail.setTo("samueldorilas@outlook.com");
//        mail.setSubject("Sending Simple Email with JavaMailSender Example");
//        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");
//
//        emailService.sendSimpleMessage(mail);
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
	
	@GetMapping("/Forgot-Password")
	public String retrieval() {
		return "_base-jsps/forgot_password.jsp";
	}
}
