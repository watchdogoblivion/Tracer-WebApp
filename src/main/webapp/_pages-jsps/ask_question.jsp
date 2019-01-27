<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="css/login.css">
		<title>Ask a Question</title>
	</head>
	<body>
		<jsp:include page="../_base-jsps/header.jsp"></jsp:include>
			<div class = "app-card-container">
				<div class = "card card-width">
					<div class = "container">
						<form class="my-2 my-lg-0" action="<%=request.getContextPath()%>/AskQuestion" method="POST" >
							<div>
								<textarea rows="3" cols="50" id="tags" name="tags" placeholder="Seperate tags by comas"></textarea>
			                </div>
							<div>
								<textarea rows="6" cols="50" id="question" name="question" placeholder="Enter question here..."></textarea>
			                </div>
			                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			                <div class="form-actions">
			               		<button class="btn" type="submit">Submit</button>
			                </div>
			            </form>
		            </div>
	            </div>
	        </div>
		<jsp:include page="../_base-jsps/footer.jsp"></jsp:include>
	</body>
</html>