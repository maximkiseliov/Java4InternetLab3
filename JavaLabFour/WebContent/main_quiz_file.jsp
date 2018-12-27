<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Boston Celtics Quiz</title>
		<link rel="shortcut icon" href="images/ico.png">
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	</head>

	<body>
		<div class="p-3 mb-2 bg-light text-dark">
		<div class="container-fluid">
		<div class="container">
		
		<center><h3>Welcome to quiz dedicated to Boston Celtics NBA team</h3></center><br>
			<form action="res" method="POST">
			<div class="form-group">
				<b>Name:</b> <input type="text" required="" class="form-control" name="username" placeholder="Your name"><br>
			</div>
				<c:forEach var="i" begin="1" end="7">
				
					<c:if test="${i == 1}">
						<!-- Question 1 -->
						How many NBA championships did Boston Celtics won (before the 2017-18 season)?<br>
						<div class="form-group">
							<select class="form-control" name="question${i}">
								<c:forEach items="${answers}" var="answer">
									<c:choose>
										<c:when test="${answer.getQuestionNumb() == i}">
											<option value="${answer.getAnswerVariant()}">${answer.getAnswerVariant()}</option>
										</c:when>
									</c:choose>
								</c:forEach>	
							</select>
						</div>
					</c:if>
					
					<c:if test="${i == 2}">
						<!-- Question 2 -->
						<br>What is the full name of Boston Celtics official mascot?<br>
						<div class="form-group">
							<textarea class="form-control" name="question${i}" placeholder="Your answer..."></textarea>
						</div>
					</c:if>
					
					<c:if test="${i == 3}">
						<!-- Question 3 -->
						<br>Which Boston Celtics player never participated in the Three Point contest?<br>
						<div class="form-check">
							<c:forEach items="${answers}" var="answer">
								<c:choose>
									<c:when test="${answer.getQuestionNumb() == i}">
										<input type="radio" class="form-check-input" name="question${i}" value="${answer.getAnswerVariant()}">${answer.getAnswerVariant()}
										<br>
									</c:when>
								</c:choose>
							</c:forEach>	
						</div>
					</c:if>
					
					<c:if test="${i == 4}">
						<!-- Question 4 -->
						<br>What is the name of Boston Celtics home arena?<br>
						<div class="form-group">
							<input type="text" class="form-control" name="question${i}" placeholder="Your answer..."></input>
						</div>
					</c:if>
					
					<c:if test="${i == 5}">
						<!-- Question 5 -->
						<br>Which NBA players formed "Big Three" in seasons 2007 - 2012?<br>
						<div class="form-check">
							<c:forEach items="${answers}" var="answer">
								<c:choose>
									<c:when test="${answer.getQuestionNumb() == i}">
										<input type="checkbox" class="form-check-input" name="question${i}" value="${answer.getAnswerVariant()}">${answer.getAnswerVariant()}
										<br>
									</c:when>
								</c:choose>
							</c:forEach>
						</div>	
					</c:if>		
					
					<c:if test="${i == 6}">
						<!-- Question 6 -->
						<br>How does Boston Celtics "Away Jersey" looks like (select by clicking on it)?<br>
						<img src="images/bostonjerseys.jpg" width="307" height="164" alt="Boston Jerseys" usemap="#jerseys">
						<input type="text" name="question${i}" id="jerseys" style="visibility: hidden; height: 0; width: 0;">
						<map name ="jerseys">
						<c:forEach items="${answers}" var="answer">
							<c:choose>
								<c:when test="${answer.getQuestionNumb() == i}">
									<area target="_self" alt="variant${answer.getId()}" title="${answer.getAnswerVariant()}" href="#" coords="${answer.getAnswerVariant()}" shape="rect" onclick="getAnswer(event)">
								</c:when>
							</c:choose>
						</c:forEach>	
						</map>
					</c:if>					
										
				</c:forEach>
				<script>
				function getAnswer(e) {
					e.preventDefault(); 
					document.getElementById("jerseys").value = e.target.title;
				}
				</script>
				<center>
					<button class="btn btn-success">Finish</button>
		       </center>
			</form>
			
		</div>
		</div>
		</div>		
	</body>
</html>