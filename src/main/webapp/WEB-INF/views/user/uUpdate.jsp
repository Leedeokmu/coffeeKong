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
<title>COFFEE KONG.</title>
</head>
<body>
	<div class="hor_center"><h3>EDIT YOUR INFORMATION</h3></div><br />
	<div class="container hor_center">
		<form action="" method="POST" class="form-horizontal" name="uupdate" style="width:50em">
			<input type="hidden" name="email" value="${login.email}" />
			<div class="">
				<div class="form-group ver_center">
					<label class="control-label col-md-2">EMAIL</label>&nbsp;
					<div class="col-md-10">	${login.email }</div>
				</div>
				<div class="form-group ver_center">
					<label for="fname" class="control-label col-md-2">FIRST NAME</label>&nbsp;
					<div class="col-md-10">	<input type="text" id="fname" name="fname" class="form-control" value="${login.fname}"/></div>
				</div>
				<div class="form-group ver_center">
					<label for="lname" class="control-label col-md-2">LAST NAME</label>&nbsp;
					<div class="col-md-10"><input type="text" id="lname" name="lname" class="form-control" value="${login.lname}" /></div>
				</div>
				<div class="form-group ver_center">
					<label for="pwd" class="control-label col-md-2">PASSWORD</label>&nbsp;
					<div class="col-md-10"><input type="password" class="form-control" id="pwd" name="pwd"/></div>
				</div>
				<div class="form-group ver_center">
					<label for="pwconfirm" class="control-label col-md-2">CONFIRM</label>&nbsp;
					<div class="col-md-10"><input type="password" class="form-control" id="pwconfirm" name="pwdconfirm"/></div>
				</div>
				<div class="hor_center">
				<div class="btn-group">
					<input type="submit" value="ACCEPT" class="btn btn-default"/>
					<a href="/index" class="btn btn-default">BACK TO MAIN</a>
				</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>