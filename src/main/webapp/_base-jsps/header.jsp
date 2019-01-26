<%@ page import="com.sdorilas.tracer.tracerapp.helpers.*, java.util.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
	    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
	    <link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link>
	    
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	    <link type="text/css" rel="stylesheet" href="css/header.css">
	    <link rel="icon" type="image/x-icon" href="/favicon.ico" />
    </head>

    <body>
	    <div class= "col-md-12" id="col-12-style">
	        <nav class=" navbar-expand-md navbar-dark " id="nav-style">
	            <div class = "row" style="padding-top:1%;">
	                <div class = "col-md-4" id="col-4-style">
	                        &emsp;
	                        <img src="img/trace.png"
	                            width="12%"height="110%" >
	                        <a class="navbar-brand" id="brand-color" href="/">Trace</a>
	                    <button class="navbar-toggler" 
	                        type="button" 
	                        data-toggle="collapse" 
	                        data-target="#navbarSupportedContent2" 
	                        aria-controls="navbarSupportedContent2" 
	                        aria-expanded="false" 
	                        aria-label="Toggle navigation">
	                        <span class="navbar-toggler-icon"></span>
	                    </button>
	                </div>
	                <div class="col-md-8"> 
	                    <div class="collapse navbar-collapse float-right" id="navbarSupportedContent2" >
	                    	<c:if test='<%= new HeaderHelper().showSearchBar(request) %>'>
		                        <nav class="nav" > 
		                            <form class="form-inline my-2 my-lg-0" action="/Search" method="GET" accept-charset="utf-8">
		                                &emsp;
		                                <input class="searchfield" id="search_field" placeholder="Search..." aria-label="Search"  name="search_field">
		                                &emsp;
		                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		                                &emsp;
		                            </form>
		                        </nav>
		                        <form class="form-inline" style="display:inline" action="/AskQuestion" method="GET">
								    <input type="submit" style = "color: blue; border-color: blue; " value="Ask a Question" />
								</form>
								&emsp;
	                        </c:if> 
	                        <c:if test='<%= new HeaderHelper().showLogin(request) %>'>
	                        	<a href="<%=request.getContextPath()%>/Login">Login</a>&emsp;
	                        </c:if> 
	                        <c:if test="<%= new HeaderHelper().showLogout(request) %>">
	                        	<a href="<%=request.getContextPath()%>/logout">Logout</a>&emsp;
	                        </c:if> 
	                        <c:if test="<%= new HeaderHelper().showRegister(request) %>">
	                        	<a href="<%=request.getContextPath()%>/Register">Register</a>&emsp;
	                        </c:if>
	                    </div>
	                </div> 
	            </div>
	        </nav>
	    </div>
	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>