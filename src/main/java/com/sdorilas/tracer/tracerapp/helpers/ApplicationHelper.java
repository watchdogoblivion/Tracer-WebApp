package com.sdorilas.tracer.tracerapp.helpers;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


public class ApplicationHelper {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy", Locale.US);
	
	public String line_limiter(HttpServletRequest request, String question, int limit) {
		if(limit > question.length()) {
			return question;
		}
		return question.substring(0, limit) + "....";
	}
	
	public DateTimeFormatter getFormatter() {
		return formatter;
	}
}
