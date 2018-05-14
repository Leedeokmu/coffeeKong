<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath }"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
</head>
<body>
	<div class="container" style="width:30em;height:40em">
		<div class="u_title">
			<h2>CONTACT US</h2>
		</div>
		<form action="#">
			<div>
				<div><input type="text" name="name" class="form-control" placeholder="Input your name"/></div><br />
				<div><input type="email" name="email" class="form-control" placeholder="Input your email"/></div><br />
				<div><textarea name="content" class="form-control" placeholder="what can we help?"></textarea></div><br />
			</div>
			<div style="display:flex;justify-content:flex-end;">
				<input type="submit" class="btn btn-default" value="send"/>
			</div>
		</form>
	</div>
</body>
</html>