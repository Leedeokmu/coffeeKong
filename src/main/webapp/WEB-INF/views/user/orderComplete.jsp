<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath }"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<h2>ORDER COMPLETE</h2>
			<div class="btn-group hor_center">
				<a href="/user/order/list" class="btn btn-default">TO MY ORDER</a>
				<a href="/index" class="btn btn-default">TO HOME</a>
			</div>
		</div> 
	</div>
</body>
</html>