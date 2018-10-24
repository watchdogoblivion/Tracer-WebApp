package com.sdorilas.tracer.tracerapp.helpers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sdorilas.tracer.tracerapp.components.AuthenticationFacade;

@Component("header_helper")
public class HeaderHelper {
	@Autowired
	AuthenticationFacade facade;
	private HeaderHelper helper;

	public void setup(HttpServletRequest request) {
		ApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);
		helper = (HeaderHelper) ac.getBean("header_helper");
	}

	public boolean showLogin(HttpServletRequest request) {
		setup(request);
		String url = (String) request.getAttribute("javax.servlet.forward.request_uri");
		if(url.equals("/Login") || url.equals("/Logout")) {
			return false;
		}
		if(!helper.facade.getAuthentication().getName().equals("anonymousUser")) {
			return false;
		}
		return true;
	}

	public boolean showLogout(HttpServletRequest request) {
		setup(request);
		if (helper.facade.getAuthentication().getName().equals("anonymousUser")) {
			return false;
		}
		return true;
	}

	public boolean showRegister(HttpServletRequest request) {
		setup(request);
		String url = (String) request.getAttribute("javax.servlet.forward.request_uri");
		if (url.equals("/Register")) {
			return false;
		}
		if (!helper.facade.getAuthentication().getName().equals("anonymousUser")) {
			return false;
		}
		return true;
	}
	
	public boolean showSearchBar(HttpServletRequest request) {
		setup(request);
		String url = (String) request.getAttribute("javax.servlet.forward.request_uri");
		if (url.equals("/Login") || url.equals("/Logout") || url.equals("/Register") || url.equals("/Forgot-Password")) {
			return false;
		}
		return true;
	}
}
