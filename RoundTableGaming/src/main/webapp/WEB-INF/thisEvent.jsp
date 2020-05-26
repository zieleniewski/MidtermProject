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
<title>THIS Event</title>
</head>

<body>
		<div class="navbar">
			<jsp:include page="navbar.jsp" />
			<br>
		</div>
		
		<div class="container-event">
		<table class="table table-dark table-hover">
			<thead>
				<br>
				<div class="text-center">
				<h2>
					<th>${event.title}</th>
				</h2>
				</div>
			</thead>
			<tbody>
				<!-- 
					?Image?
				 -->
			<tr>
				<!-- On [??/??/????] @ [??:??]-->
				<br>
				<td class="text-center"><h3>On ${event.eventDate }</h3></td>
				<br> 
				<td class ="text-center"><h3>@ ${event.startTime }</h3></td>
				<br>
			</tr>
			
			<tr>
				<td class="text-center"><h3>Created By: ${event.organizer }</h3>
					<br>
					<br>
				</td>
			</tr>
			
			<tr>
				<td>${event.description }
				<br>
				<br>
				</td>
				
			</tr>
			
			<tr>
				<td>Game(s) at this event</td>
			</tr>
			<c:forEach var="eventGame" items="${event.eventGames }">
				<tr>
					<td>${eventGame.title } </td>
				</tr>
				<tr>
					<td>${eventGame.description }</td>
				</tr>
				<tr>
					<td>Signed up= ${eventGame.players.size()} / ${eventGame.maxPlayers }</td>
				</tr>
				<!-- I want to list the users attending each game. Not 100% on how to get usernames -->
				<tr>
					<td>
						<c:forEach var="attendee" items="${eventGame.players }">
							<!-- Pick the one that works -->
							${attendee.user.username }
							<br>
							${attendee.user.getUsername() }
							<br>
							${attendee.user.getUsername }
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
			<!-- Address of the event
			               Address: (street1)  (street2)
			                        (city) (state), (zipcode)  -->
			<tr>
				<!-- Trying to center by right justifying the left column and left justifying the second column -->
				<td class= "float-center">
					<td class= "text-right">
						<br><br>
						Address:
						<br><br><br>	
					</td>
					<td class= "text-left">
						<br><br>
						<!-- Notice the same problem as above needs to be figured out -->
						${event.address.street1}   ${event.address.street2 } <br>
						${event.address.city } ${event.address.state}, ${event.address.zipCode }
						<br> 
					</td>
				</td>
			</tr>
			</tbody>
			<tfoot class= "text-center">
				Max Capacity(${event.capacity})
			</tfoot>
		</table>
		<br><br><br><br>
		</div>

</body>
</html>