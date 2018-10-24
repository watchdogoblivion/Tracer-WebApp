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
						<c:when test="${TEST1}">
							<% List<User> users = new JspDAO().getUsers(request); %>
							<script>
								var jsArray = [];
								<% for(User user:users){%> 
									jsArray.push("<%= user.getEmail() %>")
								<% } %>
								disableEnter();
							</script>
					        <form name="form1" action="<%=request.getContextPath()%>/Forgot-Password" method="POST" onsubmit="return validateForm(jsArray);">
								<fieldset>
									<legend>Enter Email Address</legend>
									<label id="email_warning"><b>${WARNING}</b></label> 
									<label for="email">Email</label> 
									<input type="text" placeholder="Enter Email" name="email" onblur="emailExists(jsArray)" required /> 
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									<div class="form-actions">
										<button type="submit" class="btn">Submit</button>
									</div>
								</fieldset>
							</form>
					    </c:when>
						<c:when test="${TEST2}">
					        Password has been sent!
					         <div class="container signin">
							    <p><a href="<%=request.getContextPath()%>/Login">Sign in</a></p>
							  </div> 
					    </c:when>
						<c:otherwise>
					    </c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript" src="js/forgot_password.js"></script>
	</body>
</html>