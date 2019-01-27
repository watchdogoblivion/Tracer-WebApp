<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@ page import="com.sdorilas.tracer.tracerapp.dto.*, com.sdorilas.tracer.tracerapp.dao.*, java.util.*,
java.time.format.DateTimeFormatter, com.sdorilas.tracer.tracerapp.helpers.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Questions</title>
		<link type="text/css" rel="stylesheet" href="css/index.css">
	</head>
	<body>
		<jsp:include page="../_base-jsps/header.jsp"></jsp:include>
			<div class = "app-card-container">
				<div class = "card card-width">
					<div class = "container container-custom">
						<div style="padding: 1%">Questions</div>
						<table class="table-cust">
							<%List<Question> questions = (List<Question>)request.getAttribute("Questions");%>
							<% for(Question question:questions){ %>
								<tr >
									<td class="td-custom" >
										<div style="min-width: 1000px; width: 100%"><b id="b">Question:</b> <%= new ApplicationHelper().line_limiter(request, question.getQuestion(), 250) %></div>
										<div><b>By User:</b> <%= question.getUser().getUsername()%></div>
										<div><b>Created:</b> <%= question.getDateTime().format(new ApplicationHelper().getFormatter())%></div>
									</td>
								</tr>
							<%} %>
						</table>
						<input type="hidden" name="Selection" />
						<input type="hidden" name="Page" />
						<nav aria-label="Page navigation example">
						  <ul class="pagination">
						  	<%= new SearchHelper().jumpPrevious(request) %>
						  	<%= new SearchHelper().previous(request) %>
						    <%= new SearchHelper().goTo(request) %>
						    <%= new SearchHelper().next(request) %>
						    <%= new SearchHelper().jumpNext(request) %>
						  </ul>
						</nav>
					</div>
				</div>
			</div>
		<jsp:include page="../_base-jsps/footer.jsp"></jsp:include>
	</body>
</html>