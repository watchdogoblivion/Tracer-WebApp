package com.sdorilas.tracer.tracerapp.helpers;

import javax.servlet.http.HttpServletRequest;


public class IndexHelper {

	public String line_limiter(HttpServletRequest request, String question, int limit) {
		if(limit > question.length()) {
			return question;
		}
		return question.substring(0, limit) + "....";
	}
}
