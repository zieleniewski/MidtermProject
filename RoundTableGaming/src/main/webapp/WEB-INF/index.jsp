<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Round Table Gaming</title>



<!-- <!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
-->
<link rel="stylesheet" href="css/stylesheet.css" type="text/css">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container-fluid">


		<div class="navbar">
			<jsp:include page="navbar.jsp" />
		</div>

		<div class="carousel">
			<jsp:include page="carousel.jsp"></jsp:include>
		</div>

		<div class="footer">


			<div class="container">
				<div class="row">
					<div class="col-sm">
					Table Top
						<a href="rpg.do"><img class="img-responsive"
							src="https://geekandsundry.com/wp-content/uploads/2018/11/Video-Games-RPG-FI.png"
							style="height: 200px; width: 100%; display: inline-block"></a>

					</div>
					<div class="col-sm">
						Trading Card <a href="miniature.do"><img class="img-responsive"
							src="https://upload.wikimedia.org/wikipedia/en/2/24/CCG_card_back_image_assortment.jpg"
							style="height: 200px; width: 100%; display: inline-block"></a>

					</div>
					<div class="col-sm">
						Mini <a href="tcg.do"><img class="img-responsive"
							src="https://cf.geekdo-images.com/imagepage/img/z0AI_-IWdbGh870R6FOOx6Ep08o=/fit-in/900x600/filters:no_upscale()/pic5336547.jpg"
							style="height: 200px;; width: 100%; display: inline-block"></a>


					</div>
				</div>
			</div>




		</div>
		<div></div>
</body>
</html>















