<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Events</title>
</head>
<body>
	<div class="navbar">
		<jsp:include page="navbar.jsp" />
		<br> <br> <br>
	</div>
	<h1>TEST</h1>


	<div class="game-list">
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<h2>
						<th scope="col">Upcoming Events</th>
					</h2>
					<h2>
						<th scope="col">Date</th>
					</h2>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="events" items="${event}">
					<tr>
						<h3>
							<td>${events.title}</td>
						</h3>
						<h3>
							<td>${events.eventDate }</td>
						</h3>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>






	<%-- <ul>
	<c:forEach var="atten" items="${attendees}">
		<li>key: ${atten.key} value: ${atten.value.user.username}</li>
	</c:forEach>
	</ul> --%>
	<jsp:include page="login-popout.jsp"></jsp:include>
</body>
</html>