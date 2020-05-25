<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Insert title here</title>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/account.css" type="text/css">
<meta charset="utf-8">



</head>
<div class="navbar">
	<jsp:include page="navbar.jsp" /><br> <br>
</div>
<body>
	<div class="container p-0">



		<div class="row">
			<div class="col-md-5 col-xl-4">

				<div class="card">
					<div class="card-header">
						<h5 class="card-title mb-0">Profile Settings</h5>
					</div>

					<div class="list-group list-group-flush" role="tablist">
						<a class="list-group-item list-group-item-action active"
							data-toggle="list" href="#account" role="tab"> Account </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#password" role="tab"> Password </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#upcoming-games" role="tab"> Upcoming Games </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#game-history" role="tab"> Game History </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#" role="tab"> Delete account </a>
					</div>
				</div>
			</div>

			<div class="col-md-7 col-xl-8">
				<div class="tab-content">
					<div class="tab-pane fade show active" id="account" role="tabpanel">

						<div class="card">
							<div class="card-header">
								<div class="card-actions float-right"></div>
								<h5 class="card-title mb-0">Public info</h5>
							</div>
							<div class="card-body">
								<form action="updateAccount.do" method="post">
									<div class="row">
										<div class="col-md-8">
											<div class="form-group">
												<label for="inputUsername">Username</label> <input
													type="text" class="form-control" id="inputUsername" name="username"
													value="${loggedInUser.username}">
											</div>
											<div class="form-group">
												<label for="inputUsername">Biography</label>
												<textarea rows="2" class="form-control" id="inputBio"
													placeholder="Tell something about yourself"></textarea>
											</div>
										</div>
										<div class="col-md-4">
											<div class="text-center">
												<img alt="Andrew Jones"
													src="https://static.artfire.com/uploads/mfs/items/3c/58/large/3c58575a667b657c32614b0a891c3477b4ea7e937b4766d45ab41ef84ea8c9bc.jpg"
													class="rounded-circle img-responsive mt-2" width="128"
													height="128">
												<div class="mt-2">
													<!-- <span class="btn btn-primary"><svg
															class="svg-inline--fa fa-upload fa-w-16"
															aria-hidden="true" data-prefix="fas" data-icon="upload"
															role="img" xmlns="http://www.w3.org/2000/svg"
															viewBox="0 0 512 512" data-fa-i2svg="">
															<path fill="currentColor"
																d="M296 384h-80c-13.3 0-24-10.7-24-24V192h-87.7c-17.8 0-26.7-21.5-14.1-34.1L242.3 5.7c7.5-7.5 19.8-7.5 27.3 0l152.2 152.2c12.6 12.6 3.7 34.1-14.1 34.1H320v168c0 13.3-10.7 24-24 24zm216-8v112c0 13.3-10.7 24-24 24H24c-13.3 0-24-10.7-24-24V376c0-13.3 10.7-24 24-24h136v8c0 30.9 25.1 56 56 56h80c30.9 0 56-25.1 56-56v-8h136c13.3 0 24 10.7 24 24zm-124 88c0-11-9-20-20-20s-20 9-20 20 9 20 20 20 20-9 20-20zm64 0c0-11-9-20-20-20s-20 9-20 20 9 20 20 20 20-9 20-20z"></path></svg>
														<i class="fas fa-upload"></i> Upload</span> -->
												</div>
												<small></small>
											</div>
										</div>
									</div>
									<input type="hidden" name="role" value="${loggedInUser.role}">
									<input type="hidden" name="firstName" value="${loggedInUser.firstName}">
									<input type="hidden" name="lastName" value="${loggedInUser.lastName}">
									<input type="hidden" name="email" value="${loggedInUser.email}">
									<input type="hidden" name="avatar" value="${loggedInUser.avatar}">
									<input type="hidden" name="enabled" value="${loggedInUser.enabled}">
									<input type="hidden" name="admin" value="${loggedInUser.admin}">
									<input type="hidden" name="id" value="${loggedInUser.id}">
									<input type="hidden" name="password" value="${loggedInUser.password}">
									<button type="submit" class="btn btn-primary">Save
										changes</button>
								</form>

							</div>
						</div>

						<div class="card">
							<div class="card-header">
								<div class="card-actions float-right"></div>
								<h5 class="card-title mb-0">Private info</h5>
							</div>
							<div class="card-body">
								<form action="updateAccount.do" method=post>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="inputFirstName">First name</label> <input
												type="text" class="form-control" id="inputFirstName"
												value="${loggedInUser.firstName}" name="firstName">
										</div>
										<div class="form-group col-md-6">
											<label for="inputLastName">Last name</label> <input
												type="text" class="form-control" id="inputLastName"
												value="${loggedInUser.lastName}" name="lastName">
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail4">Email</label> <input type="email"
											class="form-control" id="inputEmail4" value="${loggedInUser.email}" name="email">
									</div>
									<div class="form-group">
										<label for="inputAddress">Address</label> <input type="text"
											class="form-control" id="inputAddress"
											value="${loggedInUser.address.street1}" name="street1">
									</div>
									<div class="form-group">
										<label for="inputAddress2">Address 2</label> <input
											type="text" class="form-control" id="inputAddress2"
											value="${loggedInUser.address.street2}" name="street2">
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="inputCity">City</label> <input type="text"
												value="${loggedInUser.address.city}" class="form-control" id="inputCity" name="city">
										</div>
										<div class="form-group col-md-4">
											<label for="inputState">State</label> <select id="inputState"
												class="form-control" name="state">
												<option selected="">${loggedInUser.address.state}</option>
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
										<div class="form-group col-md-2">
											<label for="inputZip">Zip</label> <input type="text"
											value="${loggedInUser.address.zipCode}" class="form-control" id="inputZip" name="zipCode">
										</div>
									</div>
									<input type="hidden" name="id" value="${loggedInUser.id}">
									<button type="submit" class="btn btn-primary">Save
										changes</button>
								</form>

							</div>
						</div>

					</div>
					<div class="tab-pane fade" id="password" role="tabpanel">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Password</h5>

								<form>
									<div class="form-group">
										<label for="inputPasswordCurrent">Current password</label> <input
											type="password" class="form-control"
											id="inputPasswordCurrent"> <small><a href="#">Forgot
												your password?</a></small>
									</div>
									<div class="form-group">
										<label for="inputPasswordNew">New password</label> <input
											type="password" class="form-control" id="inputPasswordNew">
									</div>
									<div class="form-group">
										<label for="inputPasswordNew2">Verify password</label> <input
											type="password" class="form-control" id="inputPasswordNew2">
									</div>
									<button type="submit" class="btn btn-primary">Save
										changes</button>
								</form>

							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="upcoming-games" role="tabpanel">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Upcoming Games</h5>

								<form>
									<ul>
										<c:forEach var="event" items="${category}">
											<h3>${event.title}<br> ${event.eventDate }
											</h3>
										</c:forEach>

									</ul>
								</form>

							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="game-history" role="tabpanel">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Game History</h5>

								<form>
									<ul>
										<c:forEach var="event" items="${category}">
											<h3>${event.title}<br> ${event.eventDate }
											</h3>
										</c:forEach>

									</ul>
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>