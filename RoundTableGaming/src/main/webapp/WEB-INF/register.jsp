<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="css/register.css" type="text/css"> 

<title>Sign Up</title>
</head>
<body>
<div class="narbar-rpg">
			<jsp:include page="navbar.jsp" />
		</div>	
			<br><br>
<div class="container-register ">
            <form class="form-horizontal" role="form" action="registrationComplete.do" method="POST">
                <h2>Registration</h2>
                <div class="form-group ">
                    <div class="col-md-6 mx-auto">
                        <input type="text" id="firstName" placeholder="First Name" class="form-control" autofocus name="firstName">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="text" id="lastName" placeholder="Last Name" class="form-control" autofocus name="lastName">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="password" id="password" placeholder="Password" class="form-control" name="password">
                    </div>
                </div>
               
              
                <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="text" id="userName" placeholder="Username" class="form-control" name="username">
                        <span class="help-block"> </span>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="text" id="street1" placeholder="Address" class="form-control" name="street1">
                    </div>
                </div>
                 <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="text" id="street2" placeholder="Address" class="form-control" name="street2">
                    </div>
                </div>
                 <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <input type="text" id="city" placeholder="City" class="form-control" name="city">
                    </div>
                </div>
                 <div class="form-group">
                    <div class="col-md-6 mx-auto">
                        <select id="inputState" class="form-control" name="state">
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
                        <input type="text" id="zipCode" placeholder="Zip Code" class="form-control" name="zipCode">
                    </div>
                </div>
                
                      
               
               
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form> 
                    </div>
        
        <jsp:include page="login-popout.jsp"></jsp:include>
</body>
</html>