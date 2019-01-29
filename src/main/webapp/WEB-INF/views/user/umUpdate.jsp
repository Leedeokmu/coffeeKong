<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
</head>
<body>
	<div class="a_title text-center"><h2><span>MODIFY USER INFORMATION</span></h2></div><br />
	<div class="container">
		<form action="/manage/user/update/save" class="form-horizontal" method="POST" name="umupdate">
			<input type='hidden' name='email' value="${uvo.email}">
			<input type='hidden' name='page' value="${cri.page}"> 
			<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
			<input type='hidden' name='searchType' value="${cri.searchType}">
			<input type='hidden' name='keyword' value="${cri.keyword}">
			<div>
				<div class="form-group ver_center">
					<label  class="control-label col-md-3">EMAIL</label>
					<div class="col-md-9"><span>${uvo.email }</span></div>
				</div>
				<div class="form-group ver_center">
					<label class="control-label col-md-3">FIRST NAME</label>&nbsp;
					<div class="col-md-9"><input type="text" name="fname" class="form-control" value="${uvo.fname }" /></div>
				</div>
				<div class="form-group ver_center">
					<label class="control-label col-md-3">LAST NAME</label>&nbsp;
					<div class="col-md-9"><input type="text" name="lname" class="form-control" value="${uvo.lname }" /></div>
				</div>
				<div class="form-group ver_center">
					<label class="control-label col-md-3">PASSWORD</label>&nbsp;
					<div class="col-md-9"><input type="password" class="form-control" name="pwd" /></div>
				</div>
				<div class="hor_center">	
					<div class="btn-group">
						<input type="submit" class="btn btn-default" value="ACCEPT" />&nbsp;
						<a href="/manage/user/list" class="btn btn-default ulBtn" >TO LIST</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<form name="ulist">
		<input type='hidden' name='email' value="${uvo.email}">
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
		$(".ulBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[name="ulist"]');
			form.find('input[name="email"]').attr("value", encodeURI(form.find('input[name="email"]').attr("value")));
			form.attr("method", "get");
			form.attr("action", "/manage/user/list");
			form.submit();
		});
	</script>
</body>
</html>
