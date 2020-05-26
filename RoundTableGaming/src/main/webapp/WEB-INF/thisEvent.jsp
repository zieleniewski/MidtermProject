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
				<div class="text-center">
				<h2>
					<th>${event.title}</th>
				</h2>
				</div>
			</thead>
			<tbody>
			<tr>
			
			</tr>
			</tbody>
		
		</table>
		
		
		
		
		
		
		</div>

</body>
</html>