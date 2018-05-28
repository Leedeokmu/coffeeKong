<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WELCOME, COFFEE KONG</title>
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/style.css" />
<link rel="stylesheet" href="/assets/css/image.css" />
<link rel="stylesheet" href="/assets/css/header.css" />
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
			data-target="#headerNav" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/index"><h3 style="margin:0px"><b>COFFEE KONG</b></h3></a>
		</div>
		<div class="collapse navbar-collapse" id="headerNav">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						ABOUT<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/info/intro">Introduction</a></li>
						<li><a href="/info/location">Location</a></li>
						<li><a href="/info/contact">Contact us</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">SHOP<span
						class="caret"> </span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header"><h4>Coffee</h4></li>
						<li><a href="/product/list/Blends">Blends</a></li>
						<li><a href="/product/list/Decafs">Decafs</a></li>
						<li><a href="/product/list/Light">Light</a></li>
						<li><a href="/product/list/Medium">Medium</a></li>
						<li><a href="/product/list/Dark">Dark</a></li>
						<li class="dropdown-header"><h4>Tools</h4></li>
						<li><a href="/product/list/grinder">Grinder</a></li>
						<li><a href="/product/list/HomeBrewing">Home Brewing</a></li>
						<li><a href="/product/list/Cups">Cups</a></li>
					</ul></li>
				<li><a href="/learn">LEARN</a></li>

				<c:catch>
					<c:choose>
						<c:when test="${login != null}">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									${login.u_email }<span class="caret"></span>
								</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="/user/update">EDIT MY
											PROFILE</a></li>
									<li><a href="/user/order/list">MY ORDER</a></li>
									<li><a href="/user/resign">RESIGN FROM
											WEBSITE</a></li>
									<li><a href="/logout">LOGOUT</a></li>
								</ul>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="#loginModal" data-toggle="modal">LOGIN</a></li>
							<li><a href="#joinModal" data-toggle="modal">JOIN</a></li>
							<div id="loginModal" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h3 class="modal-title">LOGIN</h3>
										</div>
										<div class="modal-body">
											<form action="/login" name="login" method="POST" >
												<input type="hidden" name="useCookie" value="false" />
												<div class="form-group">
													<label for="email">EMAIL</label><input type="email"
														class="form-control" name="email" id="email" />
												</div>
												<div class="form-group">
													<label for="pw">PASSWORD</label> <input type="password"
														class="form-control" name="pw"
														id="pw"/>
												</div>
												<div class="form-group">
													<label for="useCookie">Remember</label>
													<input type="checkbox" id="useCookie" name="useCookie" value="true"/>
												</div>
												<br />
												<div class="errmsg"></div>
												<div>
													<input type="submit" value="LOGIN" class="btn btn-default">&nbsp;
													<input type="reset"	class="btn btn-default" value="RESET">
												</div>
											</form>
											<br />
										</div>
									</div>
								</div>
							</div>
							<div id="joinModal" class="modal fade" role="dialog">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h3 class="modal-title">REGISTER</h3>
										</div>
										<div class="modal-body">
											<form action="/register" name="register" method="POST">
												<div class="form-group">
													<label for="uEmail">EMAIL</label> <input type="email"
														name="email" id="uEmail" class="form-control"
														placeholder="Enter Your EMAIL" />
														
												</div>
												<div class="form-group">
													<label for="uFname">FIRSTNAME</label> <input type="text"
														name="fname" id="uFname" class="form-control"
														placeholder="Enter Your FIRSTNAME" />
												</div>
												<div class="form-group">
													<label for="uLname">LASTNAME</label> <input type="text"
														name="lname" id="uLname" class="form-control"
														placeholder="Enter Your LASTNAME" />
												</div>
												<div class="form-group">
													<label for="uPwd">PASSWORD</label> <input type="password"
														name="pwd" id="uPwd" class="form-control"
														placeholder="Enter Your PASSWORD" />
												</div>
												<div class="form-group">
													<label for="pwdconfirm">CONFIRM</label> <input
														type="password" id="pwdconfirm" name="pwdconfirm"
														class="form-control" />
												</div>
												<div class="errmsg"></div>
												<br />
												<div class="ver_center">
													<input type="submit" class="btn btn-default"
														value="REGISTER" />&nbsp;&nbsp;
													<a href="/index">Back to Main</a>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:catch>
				<li><a href="/user/cart">CART : <span class="badge cart">${fn:length(cart)}</span></a></li>
			</ul>
		</div>
		<hr>
		<c:if test="${category != null }">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/product/list/SingleOrigins">Single Origins</a></li>
			<li><a href="/product/list/Blends">Blends</a></li>
			<li><a href="/product/list/Decafs">Decafs</a></li>
			<li><a href="/product/list/Light">Light</a></li>
			<li><a href="/product/list/Medium">Medium</a></li>
			<li><a href="/product/list/Dark">Dark</a></li>
			<li><a href="/product/list/grinder">Grinder</a></li>
			<li><a href="/product/list/HomeBrewing">Home Brewing</a></li>
			<li><a href="/product/list/Cups">Cups</a></li>
		</ul>
		</c:if>
	</div>
	</nav>
	
	<script src="http://code.jquery.com/jquery-3.1.1.js"
		integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
		crossorigin="anonymous"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
	<script src="http://malsup.github.io/min/jquery.form.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
	<script src="/assets/js/validate.js"></script>
	<script>
	$(document).ready(function(){
	    $(".dropdown").hover(            
	        function() {
	            $('.dropdown-menu', this).not('.in .dropdown-menu').stop( true, true ).slideDown("fast");
	            $(this).toggleClass('open');        
	        },
	        function() {
	            $('.dropdown-menu', this).not('.in .dropdown-menu').stop( true, true ).slideUp("fast");
	            $(this).toggleClass('open');       
	        }
	    );
	});
	</script>
</body>
</html>