<%@ page import="com.sdorilas.tracer.tracerapp.dto.*, com.sdorilas.tracer.tracerapp.dao.*, java.util.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="css/forgot_password.css">
		<title>Retrieve Password</title>
	</head>
	<body id="bg-color">
		<jsp:include page="header.jsp"></jsp:include>
		<div class = "app-card-container">
			<div class = "card card-width">
				<div class = "container">
					<c:choose>
						<c:when test="true">
					        <form name="f" action="/Login" method="POST">
								<fieldset>
									<legend>Enter Email Address</legend>
									<label id="email_warning"><b>${WARNING}</b></label> 
									<label for="email">Email</label> 
									<input type="text" id="email" name="email" /> 
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									<div class="form-actions">
										<button type="submit" class="btn">Log in</button>
									</div>
								</fieldset>
							</form>
					    </c:when>
						<c:when test="${param.sent}">
					        Password has been sent!
					         <div class="container signin">
							    <p><a href="/Login">Sign in</a></p>
							  </div> 
					    </c:when>
						<c:otherwise>
					    </c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>