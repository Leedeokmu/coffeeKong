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
<div class="container bg-3 text-center">
<div class="row">
	<c:forEach var="product" items="${productList}" varStatus="status">
		<div class="col-sm-4 all_center" style="margin-bottom:5em">
		    <div class="imageWrapper">
			    <div>
			    	<a href="${product.PId}">
			    		<img src="${product.PImg}" class="img-responsive thumbnail" style="width:20em;height:20em" alt="Image">
			    	</a>
			    	<a href="${product.PId}" class="cornerLink">$${product.PPrice}</a>
		    	</div>
		    	<div class="h_nav" style="font-size:125%"><a href="${product.PId}">${product.PName}</a></div>
			</div>
		    <br><br><br><br>
    	</div>
	</c:forEach>
	<form id="plistForm">
		<input type="hidden" name="pid"/>
	</form>
	<script>
		$('.imageWrapper').on("click", 'a',function(event){
			event.preventDefault();

			var target = $(this).attr("href");
			var plistForm = $("#plistForm");
			plistForm.find("[name='pid']").val(target);
			plistForm.attr("action","/product/detail");
			plistForm.attr("method", "GET");
			plistForm.submit();
		})
	</script>
	</div>
</div>
</body>
</html>