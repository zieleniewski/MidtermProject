<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Events</title>
</head>
<body>
	<div class="navbar">
		<jsp:include page="navbar.jsp" />
	</div>



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

				<c:forEach var="event" items="${category}">
					<tr>
						<h3>
							<td>${event.title}</td>
						</h3>
						<h3>
							<td>${event.eventDate }</td>
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