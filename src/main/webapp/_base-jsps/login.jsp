<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="css/index.css">
		<title>Please Login</title>
	</head>
	<body>
		<div>
			<form name="f" action="/Login" method="POST">
				<fieldset>
					<legend>Please Login</legend>
	
					<div class="alert alert-error">
						<c:choose>
							<c:when test="${param.error}">
						        Invalid username and password. 
						    </c:when>
							<c:when test="${param.logout}">
						        You have been logged out. 
						    </c:when>
							<c:otherwise>
						    </c:otherwise>
						</c:choose>
					</div>
					<label for="username">Username</label> 
					<input type="text" id="username" name="username" /> 
					<label for="password">Password</label>
					<input type="password" id="password" name="password" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="form-actions">
						<button type="submit" class="btn">Log in</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="container" style="background-color:#f1f1f1">
		    <span class="">Forgot <a href="#">password?</a></span>
		</div>
		<div class="container signin">
		    <p>Create a free Account <a href="/Register">Sign up</a>.</p>
		</div>
	</body>
</html>