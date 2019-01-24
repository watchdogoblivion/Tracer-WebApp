package com.sdorilas.tracer.tracerapp.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sdorilas.tracer.tracerapp.dto.Question;
import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.QuestionRepository;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;

@Component("jspdao")
public class JspDAO {

	private JspDAO impl;
	@Autowired
	UserRepository userRepository;
	@Autowired
	QuestionRepository questionRepository;
	
	public void setup(HttpServletRequest request) {
		ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);
		impl = (JspDAO) ac.getBean("jspdao");
	}
	
	public List<User> getUsers(HttpServletRequest request) {
		setup(request);
		List<User> users = impl.userRepository.findAll();
		return users;
	}
	
	public List<Question> getQuestions(HttpServletRequest request) {
		setup(request);
		List<Question> questions = impl.questionRepository.findAll();
		return questions;
	}
	
	public List<Question> getRecentQuestions(HttpServletRequest request) {
		setup(request);
		LocalTime lt = LocalTime.of(0, 0);
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.of(ld, lt);
		List<Question> questions = impl.questionRepository.findRecent(ldt);
		return questions;
	}
	
	public List<Question> getLastQuestions(HttpServletRequest request) {
		setup(request);
		List<Question> questions = impl.questionRepository.findLastTen();
		return questions;
	}
}
