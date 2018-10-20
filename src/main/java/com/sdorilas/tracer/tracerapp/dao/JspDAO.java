package com.sdorilas.tracer.tracerapp.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;

@Component("jspdao")
public class JspDAO {

	@Autowired
	public UserRepository userRepository;

	public List<User> getUsers(HttpServletRequest request) {
		ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);
		JspDAO userimpl = (JspDAO) ac.getBean("jspdao");
		List<User> users = userimpl.userRepository.findAll();
		return users;
	}
}
