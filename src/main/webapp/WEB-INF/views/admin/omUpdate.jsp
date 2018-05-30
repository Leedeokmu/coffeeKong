<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG</title>
</head>
<body>
	<div class="a_title text-center"><h3>MODIFY ORDER INFORMATION</h3></div><br />
	<form action="/manage/order/update/save" method="POST" class="form-horizontal" name="omupdate">
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">
	<div class="container a_article">
		<div>
			<div class="form-group ver_center">
				<label class="control-label col-md-3">ORDER ID</label>
				<div class="col-md-9"><input type="text" class="form-control" name="id" value="${ovo.id}" readonly/></div>
			</div>
			<div class="form-group ver_center">
				<label class="control-label col-md-3">STATE</label>
				<div class="col-md-9"><input type="text" class="form-control" name="state" value="${ovo.state}" readonly/></div>
			</div>
			<div class="form-group ver_center">
				<label class="control-label col-md-3">PRICE</label>
				<div class="col-md-9"><input type="text" class="form-control" name="price" value="${ovo.price}"/></div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">FIRST NAME</label>
				<div class="col-md-9"><input type="text" class="form-control"name="fname" value="${ovo.fname }"/></div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">LAST NAME</label>
				<div class="col-md-9"><input type="text" class="form-control"name="lname" value="${ovo.lname }"/></div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">PHONE</label>
				<div class="col-md-9"><input type="text" class="form-control" name="phone" value="${ovo.phone }"/></div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">POST CODE</label>
				<div class="col-md-9"><input type="text" class="form-control"name="postcode" value="${ovo.postcode }"/></div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">ADDRESS</label>
				<div class="col-md-9"><textarea name="addr" class="form-control" cols="30" rows="2">${ovo.addr }</textarea></div>
			</div>
		</div>
		<div class="hor_center">
			<div class="btn-group">
				<input type="submit" class="btn btn-default" value="ACCEPT"/>
				<a href="#" class="btn btn-default omlBtn">BACK</a>
			</div>
		</div>
	</div>
	</form>
	<form role="form">
		<input type="hidden" name="id" value="${ovo.id}"/>
		<input type='hidden' name='page' value="${cri.page}">
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>
	<script>
		$(".omlBtn").on("click",function(e){
			e.preventDefault();
			var form = $('form[role="form"]');
			form.attr("method", "get");
			form.attr("action", "/user/order/detail");
			form.submit();
		});
	</script>
</body>
</html>