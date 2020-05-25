<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/createEvent.css" type="text/css">


</head>
<body>
<div class="main-body">
	<div class="narbar-rpg">
		<jsp:include page="navbar.jsp" />
	</div>
	<br>
	<br>
	<br>
	<div class="container-register">

		<h2>Create New Event</h2>
		<form class="form" role="form" action="createEvent.do" method="POST">


			<div class="form-group">
				<label for="eventName" class="col-sm-3 control-label"></label>
				<div class="col-sm-9">
					<input type="text" id="eventName" placeholder="Event Name"
						class="form-control" autofocus name="eventName">
				</div>
			</div>
			<!-- <!-- put drop down of games here with five rows  -->


			<div class="input-group mb-3">

				<div class="input-group-prepend"></div>
				<div class="col-sm-9">
					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend"></div>
				<div class="col-sm-9">

					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend"></div>
				<div class="col-sm-9">

					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend"></div>
				<div class="col-sm-9">

					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend"></div>
				<div class="col-sm-9">

					<select class="custom-select" id="inputGroupSelect01">
						<option selected>Select Game Title</option>
						<c:forEach var="games" items="${games}">
							<option value="${games.id }">${games.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>


					

			<div class="form-group">
				<label for="description" class="col-sm-9 control-label">
					</label>
				<div class="col-sm-9">
					<input type="text" id="description" placeholder="Event Description "
						class="form-control" name="description">
				</div>
			</div>


			<div class="form-group">
				<label for="maxPlayers" class="col-sm-3 control-label">
					 </label>
				<div class="col-sm-9">
					<input type="text" id="maxPlayers" placeholder="Max Players"
						class="form-control" name="maxPlayers"> <span
						class="help-block"> </span>
				</div>
			</div>
			<div class="form-group">
				<label for="street1" class="col-sm-3 control-label">
				</label>
				<div class="col-sm-9">
					<input type="text" id="street1" placeholder="Address"
						class="form-control" name="street1">
				</div>
			</div>
			<div class="form-group">
				<label for="street2" class="col-sm-3 control-label">
				</label>
				<div class="col-sm-9">
					<input type="text" id="street2" placeholder="Address"
						class="form-control" name="street2">
				</div>
			</div>
			<div class="form-group">
				<label for="city" class="col-sm-3 control-label"> </label>
				<div class="col-sm-9">
					<input type="text" id="city" placeholder="City"
						class="form-control" name="city">
				</div>
			</div>
			<div class="form-group">
				<label for="state" class="col-sm-3 control-label"> </label>
				<div class="col-sm-9">
					<input type="text" id="state" placeholder="State"
						class="form-control" name="state">
				</div>
			</div>
			<div class="form-group">
				<label for="zipCode" class="col-sm-3 control-label">
				</label>
				<div class="col-sm-9">
					<input type="text" id="zipCode" placeholder="Zip Code"
						class="form-control" name="zipCode">
				</div>
			</div>
			
					<div class="col-sm-9">
			
			<label for="eventTime">Date and time for event - </label>

			<input type="datetime-local" id="meeting-time" name="meeting-time"
				value="2018-06-12T19:30" min="2018-06-07T00:00"
				max="2018-06-14T00:00">
	</div>
			




			<button type="submit" class="btn btn-primary btn-block">Create!</button>
		</form>
	</div>

	<jsp:include page="login-popout.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
		</div>
</body>
</html>