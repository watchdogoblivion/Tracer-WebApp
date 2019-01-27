<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sdorilas.tracer.tracerapp.dto.*, com.sdorilas.tracer.tracerapp.dao.*, java.util.*,
java.time.format.DateTimeFormatter, com.sdorilas.tracer.tracerapp.helpers.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tracer</title>
		<link type="text/css" rel="stylesheet" href="css/index.css">
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
			<% List<Question> questions = new JspDAO().getLastQuestions(request); 
			DateTimeFormatter formatter; 
			formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy", Locale.US);
			%>
			<div class = "app-card-container">
				<div class = "card card-width">
					<div class = "container container-custom">
						<div style="padding: 1%">Recent Questions</div>
						<table class="table-cust">
							<% for(Question question:questions){ %>
								<tr >
									<td class="td-custom" >
										<div style="min-width: 1000px; width: 100%"><b id="b">Question:</b> <%= new ApplicationHelper().line_limiter(request, question.getQuestion(), 250) %></div>
										<div><b>By User:</b> <%= question.getUser().getUsername()%></div>
										<div><b>Created:</b> <%= question.getDateTime().format(formatter)%></div>
									</td>
								</tr>
							<%} %>
							
						</table>
					</div>
				</div>
			</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>