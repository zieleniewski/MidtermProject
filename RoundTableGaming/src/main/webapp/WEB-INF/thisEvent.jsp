<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/thisEvent.css" type="text/css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
</head>

<body>
	<div class="navbar">
		<jsp:include page="navbar.jsp" />
		<br>
	</div>

	<div class="whole-body">
		<div class="text ">
			<table class="table table-dark table-hover">
				<tbody>
					<tr>
						<th>Event Title:</th>

						<td>${event.title }</td>


					</tr>
					<tr>
						<th>Description:</th>
						<td>${event.description }</td>

					</tr>
					<tr>
						<th>Date:</th>
						<td>${event.eventDate }</td>

					</tr>
					<tr>
						<th>Start Time:</th>
						<td>${event.startTime }</td>

					</tr>
					<tr>
						<th>Capacity:</th>
						<td>${event.capacity }</td>

					</tr>
					<tr>
						<th>Games:</th>
						<td><c:forEach var="eventGames" items="${event.eventGames}">
							${eventGames.game.title }<br>
							</c:forEach></td>

					</tr>
					<tr>
						<th>Organizers:</th>
						<td>${event.organizer.firstName }</td>

					</tr>
					<tr>
						<th>Address:</th>
						<td>${event.address.street1}<br>${event.address.street2 }</td>

					</tr>
					<tr>
						<th>City:</th>
						<td>${event.address.city}</td>

					</tr>
					<tr>
						<th>State:</th>
						<td>${event.address.state}</td>

					</tr>
				</tbody>

			</table>

			<form action="joinEvent.do" method="POST">
				<p>Please Select Your Game Choice</p>
				<div>
				<c:forEach var="eventGames" items="${event.eventGames}">
					<input type="radio" id="${eventGames.id}" name="egId"
						value="${eventGames.id}"> <label for="contactChoice1">${eventGames.game.title }</label> 
						
						</c:forEach>
						
				
			
				</div>
				<div>
					<button type="submit" >Submit</button>
				</div>
			</form>





			<%-- <div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Select Which Game to Join</button>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">


					<c:forEach var="eventGames" items="${event.eventGames}">
						<a class="dropdown-item" href="jointEvent.do?id=${eventGames.id}">${eventGames.game.title }</a>
						<br>
					</c:forEach>



				</div>
			</div>
 --%>


			<!-- <div class="footer">	<a href="joinEvent.do" class="btn btn-lg btn-default"><h3><em>Join Event</em></h3></a></div> -->




		</div>

		<%-- <div class="text-center">
		<div class="container-event">
			<table class="table table-dark table-hover">
				<thead>
					<th scope="col">Event Title</th>
					<th scope="col">Event Description</th>
					<th scope="col">Event Date</th>
					<th scope="col">Event Start Time</th>
					<th scope="col">Capacity</th>
					<th scope="col">Games</th>

				</thead>
				<tbody>

					<tr>

						
						<td>${event.title }</td>
						
						<td>${event.description }</td>
						<td>${event.eventDate }</td>
						<td>${event.startTime }</td>
						<td>${event.capacity }</td>
						<td>
								<c:forEach var="eventGames" items="${event.eventGames}">
							${eventGames.game.title }<br>
								</c:forEach>
							</td>
						
					</tr>

				<thead>
					<th scope="col">Organizer</th>
					<th scope="col">Address</th>
					<th scope="col">City</th>
					<th scope="col">State</th>
				

				</thead>
				
				<tr>
				
						<td>${event.organizer.firstName }</td>
						<td>${event.address.street1}<br>${event.address.street2 }</td>
						<td>${event.address.city}</td>
						<td>${event.address.state}</td>
						
						
				</tr>
					
		</table>
			<br>
			<br>
			<br>
			<br>
		</div>
	</div>  --%>
		<c:choose>
			<c:when test="${not empty loggedInUser}">

				<div class="detailBox col-xl-4">
					<div class="titleBox">
						<label>Event Comments</label>
						<button type="button" class="close" aria-hidden="true">&times;</button>
					</div>

					<div class="actionBox"">


						<c:forEach var="userComment" items="${comments}">
							<li>


								<div class="commenterImage">
									<img
										src="https://static.artfire.com/uploads/mfs/items/3c/58/large/3c58575a667b657c32614b0a891c3477b4ea7e937b4766d45ab41ef84ea8c9bc.jpg" />
								</div>
								<div class="commentText">
									<p class="">${userComment.comment}</p>
									<p class="">posted by ${userComment.user.firstName}</p>
									<span class="date sub-text">on
										${userComment.commentDate}</span>

								</div>


							</li>
						</c:forEach>

						<form class="form-inline" role="form" action="postComment.do"
							method="post">

							<div class="form-group">
								<input type="hidden" value="${event.id}" name=evId> <input
									class="form-control" type="text" placeholder="Your comments"
									name="comment" />
							</div>
							<div class="form-group">
								<button type="submit" style="margin-left: 20px;">Add</button>
							</div>
						</form>
					</div>
				</div>
			</c:when>
		</c:choose>
		<jsp:include page="login-popout.jsp"></jsp:include>
	</div>
</body>
</html>