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

	<ul>
	<c:forEach var="atten" items="${attendees}">
		<li>key: ${atten.key} value: ${atten.value.user.username}</li>
	</c:forEach>
	</ul>

</body>
</html>