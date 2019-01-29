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
				<li><a href="/learn">LEARN</a></li>
			</ul>
		</div>
		<hr>
	</div>
	</nav>
	<script src="/vendor/plugins/jQuery/jQuery-3.1.1.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="/vendor/plugins/jQuery/jquery.validate.min.js"></script>
	<script src="/vendor/plugins/jQuery/jquery.form.min.js"></script>
	<script src="/vendor/plugins/jQuery/additional-methods.min.js"></script>
	<script src="/assets/js/validate.js"></script>
	<script>
	</script>
</body>
</html>