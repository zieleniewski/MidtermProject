<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/login-popout.css" type="text/css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- Modal -->
<div class="modal fade" id="darkModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog form-dark" role="document">
    <!--Content-->
    <div class="modal-content card card-image" style="background-image: url('https://i.pinimg.com/originals/87/23/13/8723132f6b15d64873f99db412d0c739.jpg'); background-repeat:no-repeat; background-size: cover;">
      <div class="text-white rgba-stylish-strong py-5 px-5 z-depth-4">
        <!--Header-->
        <div class="modal-header text-center pb-4">
          <h3 class="modal-title w-100 white-text font-weight-bold" id="myModalLabel"><strong>Log</strong> <a
              class="green-text font-weight-bold"><strong> In</strong></a></h3>
          <button type="button" class="close white-text" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <!--Body-->
        <div class="modal-body">
        <form id="login" action="logIn.do" method="GET">
          <!--Body-->
          <div class="md-form mb-5">
            <input type="text" id="userName" class="form-control validate white-text" name="username">
            <label data-error="wrong" data-success="right" for="userName">Your username</label>
          </div>

          <div class="md-form pb-3">
            <input type="password" id="password" class="form-control validate white-text" name="password">
            <label data-error="wrong" data-success="right" for="password">Your password</label>
            
          </div>

          <!--Grid row-->
          <div class="row d-flex align-items-center mb-4">

            <!--Grid column-->
            <div class="text-center mb-3 col-md-12">
              <button type="submit" id="login-button" class="btn btn-success btn-block btn-rounded z-depth-1">Log in</button>
	</form>
            </div>
            <!--Grid column-->
          </div>
          <!--Grid row-->

          <!--Grid row-->
          <div class="row">

            <!--Grid column-->
            <div class="col-md-12">
             
            </div>
            <!--Grid column-->

          </div>
          <!--Grid row-->
        </div>
      </div>
    </div>
    <!--/.Content-->
  </div>
</div>
<!-- Modal -->

<div class="text-center">
  <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#darkModalForm"></a>
</div>


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <script>
        
    
    
    $(document).ready(function() {
		
    	clearError();
    		
    	 $('#darkModalForm').on('click','#login-button', function (event) {
    						
    		event.preventDefault();
    		var USERNAME = $("#userName").val();
     		var PASSWORD = $("#password").val();
    			
    		$.ajax({
    				
    			type : "POST",
    			url : "login.do", 
    			data : "USERNAME=" + USERNAME + "&PASSWORD=" + PASSWORD,
    			 success : function(response)  {
    					
    				if(response.status == 'FAIL') {
    					showFormError(response.errorMessageList);
    				} else {
    					//everything is O.K. user logged in successfully.
    					$('#exampleModal').modal('hide');
     						window.location.reload();
    					} 
    			}, 
    			error : function(ex) {
    				console.log(ex);
    			} */
    		});
    	});
    		
    	var PasswordField = $('#password');
    	var EmailField = $('#userName');
    	var GeneralErrorField = $('#generalErrorMessage');
    		
    	function showFormError(errorVal) {
    		//show error messages that comming from backend and change border to red.
    		for(var i=0; i < errorVal.length; i++) {
    			if(errorVal[i].fieldName === 'EMAIL') {
    				clearForm();
    				EmailField.attr("placeholder", errorVal[i].message).css("border", " 1px solid red");
    			}
    				
    			else if(errorVal[i].fieldName === 'PASSWORD'){
    				PasswordField.val('');
    				PasswordField.attr("placeholder", errorVal[i].message).css("border", " 1px solid red");
    			}
    			else if(errorVal[i].fieldName === 'FORM FAIL'){
    				clearForm();
    				GeneralErrorField.css("display", "block").html(errorVal[i].message);
    			}
    		}
    	}
    	//remove error warning tags and change tips
    	function clearError() {
    		//clear all and return it as default.
    		$('#Email').focus(function() {
    			clearForm();
    			EmailField.css("border", "1px solid lightgrey");
    			EmailField.attr("placeholder", "Email address");
    		});	
    		$('#Password').focus(function() {
    			PasswordField.val('');
    			PasswordField.css("border", "1px solid lightgrey");
    			PasswordField.attr("placeholder", "Password");
    		});
    	}
    	//clear fields and hide error tag.
    	function clearForm() {
    		EmailField.val('');
    		PasswordField.val('');
    		GeneralErrorField.css("display", "none");
    	}
    		
    });
    
    
    
   /*  $(document).ready(function(){
    	
    	

        $('#darkModalForm').on('click','#login', function (e) {
        	
        	
        	
        	
        	
        	
        	
        <form:form action="login.do" method="POST" >	
          console.log($('#userName').val());
           console.log($('#password').val());
           
    	console.log(e);
    	
    	
    	
    	
});

    }) */
    </script> -->

</body>
</html>
















