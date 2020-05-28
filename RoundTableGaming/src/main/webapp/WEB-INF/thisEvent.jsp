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
<title>Event Details</title>
<link rel="icon" 
      type="image/png" 
      href="img/favicon.ico">
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
			
				<c:choose>
			<c:when test="${not empty loggedInUser}">
			
			
<div class="join-game">
			<form action="joinEvent.do" method="POST">
				<p>Please Select The Game You Would Like To Join:</p>
				<div>
				<c:forEach var="eventGames" items="${event.eventGames}">
					<input type="radio" id="${eventGames.id}" name="egId"
						value="${eventGames.id}"> <label for="contactChoice1">${eventGames.game.title }</label> <br>
						
						</c:forEach>
						
				
			
				</div>
				<div>
					<button type="submit" >Submit</button>
				</div>
			</form>
</div>

</c:when>
<c:otherwise><h2>Please Login To Join This<br> Event Or Leave A Comment</h2></c:otherwise>
</c:choose>



			<!-- <div class="footer">	<a href="joinEvent.do" class="btn btn-lg btn-default"><h3><em>Join Event</em></h3></a></div> -->


		</div>

		
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


								<!-- <div class="commenterImage">
									<img
										src="https://static.artfire.com/uploads/mfs/items/3c/58/large/3c58575a667b657c32614b0a891c3477b4ea7e937b4766d45ab41ef84ea8c9bc.jpg" />
								</div> -->
								<div class="commentText">
									<p class="">${userComment.comment}</p>
									<p class=""><font size="1"><em>posted by <strong>${userComment.user.firstName}</strong></em></font></p>
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