<%@ page import="com.sdorilas.tracer.tracerapp.repositories.*, com.sdorilas.tracer.tracerapp.dto.*,
	com.sdorilas.tracer.tracerapp.dao.*, java.util.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registration</title>
		<link type="text/css" rel="stylesheet" href="css/registration.css">
		<% List<User> users = new JspDAO().getUsers(request); %>
	</head>
	<body>
		<script>
			var jsArray = [];
			<% for(User user:users){%> 
				jsArray.push("<%= user.getUsername() %>")
			<% } %>
			disableEnter();
		</script>
		
		<form name="form1" action="/Register" method="POST" onsubmit="return validateForm(jsArray);">
		  <div class="container">
		    <h1>Sign up</h1>
		    <hr>
			<table style="width:100%">
			  <tr><td><label class="warning" id="firstname_warning"><b></b></label></td></tr>
			  <tr>
			  	<td>
			  		<label for="firstname"><b>First Name</b></label>&emsp;
			  		<input type="text" placeholder="Enter First Name" name="firstname" value = "${USER.getFirst_name()}" required onblur="validateFirstname()" pattern="[A-Za-z-']{2,32}">
			  	</td>
			  </tr>
			  <tr><td><label class="warning" id="lastname_warning"><b></b></label></td></tr>
			  <tr>
			  	<td>
			  		<label for="lastname"><b>Last Name</b></label>&emsp;
			  		<input type="text" placeholder="Enter Last Name" name="lastname"  value = "${USER.getLast_name()}" required onblur="validateLastname()" pattern="[A-Za-z' -]{2,32}">
			  	</td>
			  </tr>
			  <tr><td><label class="warning" id="username_warning"><b></b></label></td></tr>
			  <tr>
			  	<td>
			  		<label for="username"><b>User Name</b></label>&emsp;
			  		<input type="text" placeholder="Enter User Name" name="username"  value = "${USER.getUsername()}" required onblur="validateUsername(jsArray)" pattern="[A-Za-z0-9]{1,16}">
			  	</td>
			  </tr>
			  <tr><td><label class="warning" id="email_warning"><b></b></label></td></tr>
			  <tr>
			  	<td>
			  		<label for="email"><b>Email</b></label>&emsp;
			  		<input type="text" placeholder="Enter Email" name="email"  value = "${USER.getEmail()}" required onblur="validateEmail()">
			  	</td>
			  </tr>
			  <tr><td><label class="warning" id="password_warning"><b></b></label></td></tr>
			  <tr>
			  	<td>
			  		<label for="password"><b>Password</b></label>&emsp;
			  		<input type="password" placeholder="Enter Password" name="password"  onblur="validatePassword()"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}" required>
			  	</td>
			  </tr>
			  <tr><td><label class="warning" id="psw_repeat_warning"><b></b></label></td></tr>
			  <tr>
			  	<td>
			  		<label for="psw_repeat"><b>Repeat Password</b></label>&emsp;
			  		<input type="password" placeholder="Repeat Password" name="psw_repeat" onblur="validatePasswordEquality()"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}" required>
			  	</td>
			  </tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    <hr>
		    <button type="submit" class="registerbtn">Register</button>
		  </div>
		  <div class="container signin">
		    <p>Already have an account? <a href="/Login">Sign in</a>.</p>
		  </div>
		</form>
		<script type="text/javascript" src="js/validation.js"></script>
	</body>
</html>