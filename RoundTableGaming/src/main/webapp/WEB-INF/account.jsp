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
	<jsp:include page="navbar.jsp" /><br><br>
</div>
<body>
	<div class="container p-0">

		<h1 class="h3 mb-3">Settings</h1>

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
							href="#" role="tab"> Privacy and safety </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#" role="tab"> Email notifications </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#" role="tab"> Web notifications </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#" role="tab"> Widgets </a> <a
							class="list-group-item list-group-item-action" data-toggle="list"
							href="#" role="tab"> Your data </a> <a
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
								<div class="card-actions float-right">
									<div class="dropdown show">
										<a href="#" data-toggle="dropdown" data-display="static">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" viewBox="0 0 24 24" fill="none"
												stroke="currentColor" stroke-width="2"
												stroke-linecap="round" stroke-linejoin="round"
												class="feather feather-more-horizontal align-middle">
                                            <circle cx="12" cy="12"
													r="1"></circle>
                                            <circle cx="19" cy="12"
													r="1"></circle>
                                            <circle cx="5" cy="12" r="1"></circle>
                                        </svg>
										</a>

										<div class="dropdown-menu dropdown-menu-right">
											<a class="dropdown-item" href="#">Action</a> <a
												class="dropdown-item" href="#">Another action</a> <a
												class="dropdown-item" href="#">Something else here</a>
										</div>
									</div>
								</div>
								<h5 class="card-title mb-0">Public info</h5>
							</div>
							<div class="card-body">
								<form>
									<div class="row">
										<div class="col-md-8">
											<div class="form-group">
												<label for="inputUsername">Username</label> <input
													type="text" class="form-control" id="inputUsername"
													placeholder="Username">
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
													src="https://bootdey.com/img/Content/avatar/avatar1.png"
													class="rounded-circle img-responsive mt-2" width="128"
													height="128">
												<div class="mt-2">
													<span class="btn btn-primary"><svg
															class="svg-inline--fa fa-upload fa-w-16"
															aria-hidden="true" data-prefix="fas" data-icon="upload"
															role="img" xmlns="http://www.w3.org/2000/svg"
															viewBox="0 0 512 512" data-fa-i2svg="">
															<path fill="currentColor"
																d="M296 384h-80c-13.3 0-24-10.7-24-24V192h-87.7c-17.8 0-26.7-21.5-14.1-34.1L242.3 5.7c7.5-7.5 19.8-7.5 27.3 0l152.2 152.2c12.6 12.6 3.7 34.1-14.1 34.1H320v168c0 13.3-10.7 24-24 24zm216-8v112c0 13.3-10.7 24-24 24H24c-13.3 0-24-10.7-24-24V376c0-13.3 10.7-24 24-24h136v8c0 30.9 25.1 56 56 56h80c30.9 0 56-25.1 56-56v-8h136c13.3 0 24 10.7 24 24zm-124 88c0-11-9-20-20-20s-20 9-20 20 9 20 20 20 20-9 20-20zm64 0c0-11-9-20-20-20s-20 9-20 20 9 20 20 20 20-9 20-20z"></path></svg>
														<!-- <i class="fas fa-upload"></i> --> Upload</span>
												</div>
												<small>For best results, use an image at least 128px
													by 128px in .jpg format</small>
											</div>
										</div>
									</div>

									<button type="submit" class="btn btn-primary">Save
										changes</button>
								</form>

							</div>
						</div>

						<div class="card">
							<div class="card-header">
								<div class="card-actions float-right">
									<div class="dropdown show">
										<a href="#" data-toggle="dropdown" data-display="static">
											<svg xmlns="http://www.w3.org/2000/svg" width="24"
												height="24" viewBox="0 0 24 24" fill="none"
												stroke="currentColor" stroke-width="2"
												stroke-linecap="round" stroke-linejoin="round"
												class="feather feather-more-horizontal align-middle">
                                            <circle cx="12" cy="12"
													r="1"></circle>
                                            <circle cx="19" cy="12"
													r="1"></circle>
                                            <circle cx="5" cy="12" r="1"></circle>
                                        </svg>
										</a>

										<div class="dropdown-menu dropdown-menu-right">
											<a class="dropdown-item" href="#">Action</a> <a
												class="dropdown-item" href="#">Another action</a> <a
												class="dropdown-item" href="#">Something else here</a>
										</div>
									</div>
								</div>
								<h5 class="card-title mb-0">Private info</h5>
							</div>
							<div class="card-body">
								<form>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="inputFirstName">First name</label> <input
												type="text" class="form-control" id="inputFirstName"
												placeholder="First name">
										</div>
										<div class="form-group col-md-6">
											<label for="inputLastName">Last name</label> <input
												type="text" class="form-control" id="inputLastName"
												placeholder="Last name">
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail4">Email</label> <input type="email"
											class="form-control" id="inputEmail4" placeholder="Email">
									</div>
									<div class="form-group">
										<label for="inputAddress">Address</label> <input type="text"
											class="form-control" id="inputAddress"
											placeholder="1234 Main St">
									</div>
									<div class="form-group">
										<label for="inputAddress2">Address 2</label> <input
											type="text" class="form-control" id="inputAddress2"
											placeholder="Apartment, studio, or floor">
									</div>
									<div class="form-row">
										<div class="form-group col-md-6">
											<label for="inputCity">City</label> <input type="text"
												class="form-control" id="inputCity">
										</div>
										<div class="form-group col-md-4">
											<label for="inputState">State</label> <select id="inputState"
												class="form-control">
												<option selected="">Choose...</option>
												<option>...</option>
											</select>
										</div>
										<div class="form-group col-md-2">
											<label for="inputZip">Zip</label> <input type="text"
												class="form-control" id="inputZip">
										</div>
									</div>
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