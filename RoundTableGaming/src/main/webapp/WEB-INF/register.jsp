<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/register.css" type="text/css">

<title>Sign Up</title>
</head>
<body>
<div class="narbar-rpg">
			<jsp:include page="navbar.jsp" />
		</div>	
			<br><br>
<div class="container-register">
            <form class="form-horizontal" role="form" action="registrationComplete.do" method="POST">
                <h2>Registration</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">First Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="firstName" placeholder="First Name" class="form-control" autofocus name="firstName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="lastName" placeholder="Last Name" class="form-control" autofocus name="lastName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email* </label>
                    <div class="col-sm-9">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password*</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" placeholder="Password" class="form-control" name="password">
                    </div>
                </div>
               
              
                <div class="form-group">
                    <label for="userName" class="col-sm-3 control-label">Username </label>
                    <div class="col-sm-9">
                        <input type="text" id="userName" placeholder="Username" class="form-control" name="username">
                        <span class="help-block"> </span>
                    </div>
                </div>
                <div class="form-group">
                        <label for="street1" class="col-sm-3 control-label">Address </label>
                    <div class="col-sm-9">
                        <input type="text" id="street1" placeholder="Address" class="form-control" name="street1">
                    </div>
                </div>
                 <div class="form-group">
                        <label for="street2" class="col-sm-3 control-label">Address </label>
                    <div class="col-sm-9">
                        <input type="text" id="street2" placeholder="Address" class="form-control" name="street2">
                    </div>
                </div>
                 <div class="form-group">
                        <label for="city" class="col-sm-3 control-label">City </label>
                    <div class="col-sm-9">
                        <input type="text" id="city" placeholder="City" class="form-control" name="city">
                    </div>
                </div>
                 <div class="form-group">
                        <label for="state" class="col-sm-3 control-label">State </label>
                    <div class="col-sm-9">
                        <input type="text" id="state" placeholder="State" class="form-control" name="state">
                    </div>
                </div>
                 <div class="form-group">
                        <label for="zipCode" class="col-sm-3 control-label">Address </label>
                    <div class="col-sm-9">
                        <input type="text" id="zipCode" placeholder="Zip Code" class="form-control" name="zipCode">
                    </div>
                </div>
                
                      
               
               
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form> 
                    </div>
        
        <jsp:include page="login-popout.jsp"></jsp:include>
</body>
</html>