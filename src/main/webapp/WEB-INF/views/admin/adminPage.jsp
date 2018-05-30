<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WELCOME, MANAGER</title>
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/assets/css/header.css" />
<link rel="stylesheet" href="/assets/css/style.css" />
<link rel="stylesheet" href="/assets/css/image.css" />

<script src="http://code.jquery.com/jquery-3.1.1.js"
	integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
	crossorigin="anonymous"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script src="http://malsup.github.io/min/jquery.form.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
<script src="/assets/js/validate.js"></script>
</head>

<c:choose>
	<c:when test="${content == null || content == ''}">
		<c:set var="content" value="./content.jsp" />
	</c:when>
	<c:when test="${content.equals('login') }">
		<c:set var="content" value="./login.jsp" />
	</c:when>
	<c:when test="${content.equals('umlist') }">
		<c:set var="content" value="./umList.jsp" />
	</c:when>
	<c:when test="${content.equals('umdetail') }">
		<c:set var="content" value="./umDetail.jsp" />
	</c:when>
	<c:when test="${content.equals('umupdate') }">
		<c:set var="content" value="./umUpdate.jsp" />
	</c:when>
	<c:when test="${content.equals('pmlist') }">
		<c:set var="content" value="./pmList.jsp" />
	</c:when>
	<c:when test="${content.equals('pminsert') }">
		<c:set var="content" value="./pmInsert.jsp" />
	</c:when>
	<c:when test="${content.equals('pmdetail') }">
		<c:set var="content" value="./pmDetail.jsp" />
	</c:when>
	<c:when test="${content.equals('pmupdate') }">
		<c:set var="content" value="./pmUpdate.jsp" />
	</c:when>
	<c:when test="${content.equals('omlist') }">
		<c:set var="content" value="./omList.jsp" />
	</c:when>
	<c:when test="${content.equals('omdetail') }">
		<c:set var="content" value="./omDetail.jsp" />
	</c:when>
	<c:when test="${content.equals('omupdate') }">
		<c:set var="content" value="./omUpdate.jsp" />
	</c:when>
</c:choose>
<body>
<!-- header start -->
	<div id="header">
	<!-- header start-->
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
			data-target="#mgrHeaderNav" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/manage"><h3 style="margin:0px"><b>COFFEE KONG</b></h3></a>
		</div>
		<div class="collapse navbar-collapse" id="mgrHeaderNav">
			<c:catch>
				<c:choose>
					<c:when test="${mgr != null}">
						<ul class="nav navbar-nav navbar-right">
							<li><a>${mgr.email}</a></li>
							<li><a href="/manage/user/list">MANAGE USER</a></li>
							<li><a href="/manage/product/list">MANAGE PRODUCT</a></li>
							<li><a href="/manage/order/list">MANAGE ORDER</a></li>
							<li><a href="/manage/logout">LOGOUT</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="nav navbar-nav navbar-right">
							<li class="navbar-text"><h3 style="margin:0"><span class="glyphicon glyphicon-exclamation-sign"></span>&nbsp;NOT LOGGED IN</h3></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</c:catch>
		</div>
	</div>
	</nav>
	</div>
	<!-- header end-->
	
	<!-- content start -->
	<div id="content">
		<jsp:include page="${content}"/>
	</div>
	<!-- content end -->
	
	<!-- footer start -->
	<div id="footer">
		<jsp:include page="../footer.jsp"/>
	</div>
	<!-- footer end -->
	
</body>
</html>