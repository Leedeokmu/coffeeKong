<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
</head>
<style>
	body{
		height:1000px;
	}
</style>
<body>
	<div class="container">
	<c:choose>
		<c:when test="${not empty mgr}">
			<div class="row text-center u_title" style="margin:5em"><h2>WELCOME MASTER</h2></div>
			
			<div class="row hor_center h_nav text-center" style="margin-bottom:5em">
				<div class="main_menu all_center" 
				style="background: url('/dist/img/user.jpg') no-repeat;">
					<a href="/manage/user/list"><span class="h1">MANAGE USER</span></a>
				</div>
				<div class="main_menu all_center" 
				style="background: url('/dist/img/product.jpg') no-repeat center;">
					<a href="/manage/product/list"><span class="h1">MANAGE PRODUCT</span></a>
				</div>
				<div class="main_menu all_center" 
				style="background: url('/dist/img/order.jpg') no-repeat center;">
					<a href="/manage/order/list"><span class="h1">MANAGE ORDER</span></a>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div><h2>LOGIN PLEASE</h2></div>
			<div><h4><a href="/manage/login">LOGIN PLEASE</a></h4></div>
		</c:otherwise>
	</c:choose>
	</div>
	<script>
		$('.main_menu').on("mouseenter", function(event){
			$(this).css('cursor','pointer');
			$(this).find('a').addClass("hover");
		});
		$('.main_menu').on("mouseleave", function(event){
			$(this).find('a').removeClass("hover");
		});
		
		$('.main_menu').on("click", function(event){
			var target = $(this).find('a').attr("href");
			self.location.replace(target);
		});
	</script>
</body>
</html>