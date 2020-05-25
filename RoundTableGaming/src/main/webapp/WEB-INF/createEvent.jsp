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
<br>
<br>
<br>
<div class="main-body">
	
	<div class="container-register container">

		<h2>Create New Event</h2>
		<form class="form" role="form" action="createEvent.do" method="POST">


			<div class="form-group">

				<div class="col-md-6 mx-auto">
					<input type="text" id="eventName" placeholder="Event Name"
						class="form-control" autofocus name="eventName">
				</div>
			</div>
			<!-- <!-- put drop down of games here with five rows  -->


			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
		</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect01">
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
						class="form-control" name="maxPlayers"> <span
						class="help-block"> </span>
				</div>
			</div>
			<div class="form-group">
			
				<div class="col-md-6 mx-auto">
					<input type="text" id="street1" placeholder="Address"
						class="form-control" name="street1">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="street2" placeholder="Address"
						class="form-control" name="street2">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="city" placeholder="City"
						class="form-control" name="city">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="state" placeholder="State"
						class="form-control" name="state">
				</div>
			</div>
			<div class="form-group">
				
				<div class="col-md-6 mx-auto">
					<input type="text" id="zipCode" placeholder="Zip Code"
						class="form-control" name="zipCode">
				</div>
			</div>
			
					<div class="col-md-6 mx-auto">
			
			<label for="eventTime">Date and time for event - </label>

			<input type="datetime-local" id="meeting-time" name="meeting-time"
				value="" min="2018-06-07T00:00"
				max="2025-06-14T00:00">
	</div>
			




			<button type="submit" class="btn btn-primary btn-block">Create!</button>
		</form>
		
	<jsp:include page="login-popout.jsp"></jsp:include>
	</div>


</div>
</body>
</html>