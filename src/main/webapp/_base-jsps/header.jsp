<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
	    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	    <link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link>
	    <link type="text/css" rel="stylesheet" href="css/header.css">
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
	                        <nav class="nav" > 
	                            <form class="form-inline my-2 my-lg-0" action="/search" method="get" accept-charset="utf-8">
	                                &emsp;
	                                <input class="searchfield" id="searchbox" placeholder="Search..." aria-label="Search"  name="search_field">
	                                &emsp;
	                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	                                &emsp;
	                            </form>
	                        </nav> 
	                        <a href="/Login">Login</a>&emsp;
	                        <a href="/Logout">Logout</a>&emsp;
	                    	<a href="/Register">Register</a>&emsp;
	                    </div>
	                </div> 
	            </div>
	        </nav>
	    </div>
    </body>
</html>