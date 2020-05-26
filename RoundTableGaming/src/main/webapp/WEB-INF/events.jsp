<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/events.css" type="text/css">
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
		<br>
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
				<c:forEach var="event" items="${events}">
					<tr>

						<td>${event.title}</td>
						<td>${event.eventDate }</td>
						<td></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<%-- <c:forEach var="event" items="${events }">
	<script type="text/javascript">
	var zipCodes = zipCodes + '&' + ${event.address.zipCode};
	
	colsole.log(zipCodes);
	</script>
	
	</c:forEach>
	<!-- <script type="text/javascript"> -->
	<img
		src="https://maps.googleapis.com/maps/api/staticmap?center=us&zoom=3&size=400x400&markers=size:medium%7Ccolor:red%7CDelta+${zipCodes}&key=AIzaSyBGkwnAWsK1Xff-R9G3nurccb9Wxt3d8R8">

<!-- </script> --> --%>

	<jsp:include page="login-popout.jsp"></jsp:include>
</body>
</html>






















