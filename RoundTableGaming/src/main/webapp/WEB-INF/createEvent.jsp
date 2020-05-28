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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/createEvent.css" type="text/css">
<title>Create Event</title>
<meta charset="UTF-8">
</head>
<body>
		<jsp:include page="navbar.jsp" />
		<jsp:include page="login-popout.jsp"></jsp:include>
<br>
<br>
<br>
<div class="container">
			<div class="row">
        <div class="col-md-8">
<div class="card ">
	
	<div class="card-body ">

		<h2>Create New Event</h2>

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
					<!-- <select class="custom-select" id="inputGroupSelect01" name="eventGames.game.id"> -->
					<select class="custom-select" id="inputGroupSelect01" name="eventGameIds">
						<option value="0" selected>Select Game Title</option>
						<c:forEach var="game" items="${games}">
							<option value="${game.id }">${game.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect02" name="eventGameIds">
						<option selected>Select Game Title</option>
						<c:forEach var="game" items="${games}">
							<option value="${game.id }">${game.title}</option>
						</c:forEach>
					</select>
				</div>
		</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect03" name="eventGameIds">
						<option selected>Select Game Title</option>
						<c:forEach var="game" items="${games}">
							<option value="${game.id }">${game.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">

					<select class="custom-select" id="inputGroupSelect04" name="eventGameIds">
						<option selected>Select Game Title</option>
						<c:forEach var="game" items="${games}">
							<option value="${game.id }">${game.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-6 mx-auto">
					<select class="custom-select" id="inputGroupSelect05" name="eventGameIds">
						<option selected>Select Game Title</option>
						<c:forEach var="game" items="${games}">
							<option value="${game.id }">${game.title}</option>
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
					 <select id="inputState" class="form-control" name="address.state">
						<option selected="">State...</option>
												<option>Alabama</option>
												<option>Alaska</option>
												<option>Arizona</option>
												<option>Arkansas</option>
												<option>California</option>
												<option>Colorado</option>
												<option>Connecticut</option>
												<option>Delaware</option>
												<option>Florida</option>
												<option>Georgia</option>
												<option>Hawaii</option>
												<option>Idaho</option>
												<option>Illinois</option>
												<option>Indiana</option>
												<option>Iowa</option>
												<option>Kansas</option>
												<option>Kentucky</option>
												<option>Louisiana</option>
												<option>Maine</option>
												<option>Maryland</option>
												<option>Massachusetts</option>
												<option>Michigan</option>
												<option>Minnesota</option>
												<option>Mississippi</option>
												<option>Missouri</option>
												<option>Montana</option>
												<option>Nebraska</option>
												<option>Nevada</option>
												<option>New Hampshire</option>
												<option>New Jersey</option>
												<option>New Mexico</option>
												<option>New York</option>
												<option>North Carolina</option>
												<option>North Dakatoa</option>
												<option>Ohio</option>
												<option>Oklahoma</option>
												<option>Oregon</option>
												<option>Pennsylvania</option>
												<option>Rhode Island</option>
												<option>South Carolina</option>
												<option>South Dakota</option>
												<option>Tennessee</option>
												<option>Texas</option>
												<option>Utah</option>
												<option>Vermont</option>
												<option>Virgina</option>
												<option>Washington</option>
												<option>West Virginia</option>
												<option>Wisconsin</option>
												<option>Wyoming</option>
											</select>						
						
						
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
</div>
</div>

</div>
</body>
</html>