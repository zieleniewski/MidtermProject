<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="css/createEvent.css" type="text/css">
<title>create event</title>
<meta charset="UTF-8">
</head>
<body>
		<jsp:include page="navbar.jsp" />
		<jsp:include page="login-popout.jsp"></jsp:include>
<br>
<br>
<br>
<div class="card w-75 mx-auto">
	
	<div class="card-body text-center">
<div class="card-header" style="margin-bottom: 20px">
		<h2>Create New Event</h2>
</div>
		<form class="form" role="form" action="createEvent.do" method="POST">

			<div class="form-group">

				<div class="col-md-6 mx-auto">
					<input type="text" id="eventName" placeholder="Event Name"
						class="form-control" autofocus name="title">
				</div>
			</div>
			<!-- <!-- put drop down of games here with five rows  -->


			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect01" name="eventGames.game.id">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect02" name="eventGames.game.id">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
		</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect03" name="eventGames.game.id">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect04" name="eventGames.game.id">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect05" name="eventGames.game.id">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>



			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="description" placeholder="Event Description "
						class="form-control" name="description">
				</div>
			</div>


			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<input type="text" id="maxPlayers" placeholder="Max Players"
						class="form-control" name="capacity"> <span
						class="help-block"> </span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<input type="text" id="street1" placeholder="Address"
						class="form-control" name="address.street1">
				</div>
			</div>
			<div class="form-group">				
				<div class="col-md-6 mx-auto">
					<input type="text" id="street2" placeholder="Address"
						class="form-control" name="address.street2">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="city" placeholder="City"
						class="form-control" name="address.city">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="state" placeholder="State"
						class="form-control" name="address.state">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="zipCode" placeholder="Zip Code"
						class="form-control" name="address.zipCode">
				</div>
			</div>
			
			<div class="form-group">
					<div class="col-md-6 mx-auto">
			<label for="eventTime">Date of Event - </label>


			<input type="date" id="meeting-date" name="eventDate"
				value="">
	</div>
	</div>
	
	<div class="form-group">
					<div class="col-md-6 mx-auto">
			<label for="eventTime">Time of Event - </label>
			<input type="time" id="meeting-time" name="startTime"
				value="">
				</div>
	</div>
		




			<button type="submit" class="btn btn-primary btn-block" style="margin-top: 20px;">Create!</button>
		</form>
		
	</div>


</div>
</body>
</html>