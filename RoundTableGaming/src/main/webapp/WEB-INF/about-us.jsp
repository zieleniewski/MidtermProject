<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta charset="utf-8">

<link rel="stylesheet" href="css/about-us.css" type="text/css">
<meta charset="UTF-8">
<title>About Us</title>
</head>

	<div class="navbar">
			<jsp:include page="navbar.jsp" />
			<jsp:include page="login-popout.jsp"></jsp:include>
		</div>
<!-- Modal for shane -->
<div class="modal fade" id="shane" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLongTitle"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Dad Noise Provider</h5>
				
			</div>
			<div class="modal-body">Shane is the master mind behind this entire project. Making use of his extensive in-depth knowledge, Shane was able to keep this project on track and headed in the right direction. Whenever we 
			had structural questions or decisions to make, Shane was the man to talk to.</div>
			<div class="modal-footer">
			</div>
		</div>
	</div>
</div>
<body>
<!-- Modal for serg -->
<div class="modal fade" id="serg" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLongTitle"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Database Architect </h5>
			</div>
			<div class="modal-body">Mr. Samoiloff brings much welcomed diversity to the team, hailing from the far East of <em>Somewhere</em> he was able to bring new views and ideas to the table. His unwavering patience for managing the SQL database
			and enduring the rest of the teams endless questions brought a level of professionalism rarely seen.  </div>
			<div class="modal-footer">
			</div>
		</div>
	</div>
</div>
<body>
<!-- Modal for jacob -->
<div class="modal fade" id="jacob" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLongTitle"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Jacob Who?</h5>
			</div>
			<div class="modal-body">We never did really figure out what Jacob was doing all day. It seemed that while the rest of the team was slaving away day and night Jacob never really contributed anything. Maybe he did some front end design? 
			We're not entirely sure.</div>
			<div class="modal-footer">
			</div>
		</div>
	</div>
</div>
<body>

	<div class="our-webcoderskull ">
		<div class="container">
			<div class="row heading heading-icon">
				<h2>Our Team</h2>
			</div>
			<ul class="row">
				<li class="col-12 col-md-6 col-lg-4">
					<div class="cnt-block equal-hight" style="height: 349px;">
						<figure>
							<img src="https://maximumvp.com/wp-content/uploads/2018/10/peter-family-guy-beard-bird.jpg"
								class="img-responsive" alt="">
						</figure>
						<h3>
							<a href="#">Shane Duncan</a>
						</h3>
						<p>Java Master / Dad Noises</p>
						
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#shane">Read More</button>
					
					</div>
				</li>
				<li class="col-12 col-md-6 col-lg-4">
					<div class="cnt-block equal-hight" style="height: 349px;">
						<figure>
							<img src="https://1.bp.blogspot.com/-zewCwqP8UEQ/VbOMfLUGTxI/AAAAAAAACIU/K3uFdYCkwMc/s1600/tumblr_m3ve7dciby1r5i7ado1_500.png"
								class="img-responsive" alt="">
						</figure>
						<h3>
							<a href="#">Sergio Samoiloff </a>
						</h3>
						<p>DBA Master / Angry Slav</p>
						
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#serg">Read More</button>
					</div>
				</li>
				<li class="col-12 col-md-6 col-lg-4">
					<div class="cnt-block equal-hight" style="height: 349px;">
						<figure>
							<img src="images/jacob-aboutme.jpg"
								class="img-responsive" alt="">
						</figure>
						<h3>
							<a href="#">Jacob Zieleniewski </a>
						</h3>
						<p>Front End / Master Skater</p>
						
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#jacob">Read More</button>
					</div>
				</li>

			</ul>
		</div>
	</div>



</body>
</html>