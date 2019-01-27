package com.sdorilas.tracer.tracerapp.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SearchHelper {

	public String previous(HttpServletRequest request) {
		String previous = "";
		HttpSession session = request.getSession();
		int currentPage = (int)session.getAttribute("CurrentPage");
		if(currentPage == 1){
			previous += "<li class='page-item disabled'>"
					 + 		"<a class='page-link'>"
					 + 			"Previous"
					 + 		"</a>"
					 + "</li>";
		}else{
			previous += "<li class='page-item'>"
					+ 		"<a class='page-link' href='" + request.getContextPath() + "/Search?Selection=previous'>"
					+ 			"Previous"
					+ 		"</a>"
					+ "</li>";
		}
		return previous;
	}
	
	public String jumpPrevious(HttpServletRequest request) {
		String previous = "";
		HttpSession session = request.getSession();
		int currentPage = (int)session.getAttribute("CurrentPage");
		if(currentPage < 11){
			previous += "<li class='page-item disabled'>"
					 + 		"<a class='page-link'>"
					 +       	"<span aria-hidden='true'>"
					 + 				"&laquo;"
					 + 			"</span>"
				     +  		"<span class='sr-only'>"
				     + 				"Previous"
				     + 			"</span>"
					 + 		"</a>"
					 + "</li>";
		}else{
			previous += "<li class='page-item'>"
					+ 		"<a class='page-link' href='" + request.getContextPath() + "/Search?Selection=jumpPrevious'>"
					+       	"<span aria-hidden='true'>"
					+ 				"&laquo;"
					+ 			"</span>"
				    +  			"<span class='sr-only'>"
				    + 				"Previous"
				    + 			"</span>"
					+ 		"</a>"
					+ "</li>";
		}
		return previous;
	}
	
	public String next(HttpServletRequest request) {
		String next = "";
		HttpSession session = request.getSession();
		int currentPage = (int)session.getAttribute("CurrentPage");
		long pageCount = (long)session.getAttribute("PageCount");
		if( currentPage == pageCount){
			next += "<li class='page-item disabled'>"
				  + 	"<a class='page-link'>"
				  + 		"Next"
				  + 	"</a>"
				  + "</li>";
		}else{
			next += "<li class='page-item'>"
				  + 	"<a class='page-link' href='" + request.getContextPath() + "/Search?Selection=next'>"
				  + 		"Next"
				  + 	"</a>"
				  + "</li>";
		}
		return next;
	}
	
	public String jumpNext(HttpServletRequest request) {
		String next = "";
		HttpSession session = request.getSession();
		int currentPage = (int)session.getAttribute("CurrentPage");
		long pageCount = (long)session.getAttribute("PageCount");
		if( currentPage > pageCount - 10){
			next += "<li class='page-item disabled'>"
				  + 	"<a class='page-link'>"
				  +       	"<span aria-hidden='true'>"
			      + 			"&raquo;"
			      + 		"</span>"
				  +  		"<span class='sr-only'>"
	              + 			"Next"
		          + 		"</span>"
				  + 	"</a>"
				  + "</li>";
		}else{
			next += "<li class='page-item'>"
				  + 	"<a class='page-link' href='" + request.getContextPath() + "/Search?Selection=jumpNext'>"
				  +       	"<span aria-hidden='true'>"
			      + 			"&raquo;"
			      + 		"</span>"
				  +  		"<span class='sr-only'>"
	              + 			"Next"
				  + 	"</a>"
				  + "</li>";
		}
		return next;
	}
	
	public String goTo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int inc = (int)session.getAttribute("Increment");
		int currentPage = (int)session.getAttribute("CurrentPage");
		long pageCount = (long)session.getAttribute("PageCount");
		long count = getCount(pageCount, inc);
		String goTo = "";
		for(int i = 1 + inc; i <= count; i++){
			if(currentPage == i){
				goTo += "<li class='page-item active'>"
					 + 		"<a class='page-link' href='#'>" 
					 + 			i
					 +		"</a>"
					 + "</li>";
			}else {
				goTo += "<li class='page-item'>"
					 + 		"<a class='page-link' href='" + request.getContextPath() + "/Search?Selection=goTo&Page=" + i + "'>"
					 +			i
					 +		"</a>"
					 + "</li>";
			}
		}
		return goTo;
	}

	private long getCount(long pageCount, int inc) {
		int i = 1 + inc;
		long count = 0;
		if(pageCount >= i + 10) {
			count = i + 9;
		}else {
			count = pageCount;
		}
		return count;
	}
}
