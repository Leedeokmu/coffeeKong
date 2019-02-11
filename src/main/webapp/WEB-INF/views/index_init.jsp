<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>COFFEE KONG.</title>
<style>
</style>
</head>
<body>
	<br />
	<div class="container">
		<div id="coffeeCarousel" class="carousel slide" data-ride="carousel" style="height:400px !important;">
		    <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		      <li data-target="#myCarousel" data-slide-to="2"></li>
		      <li data-target="#myCarousel" data-slide-to="3"></li>
		      <li data-target="#myCarousel" data-slide-to="4"></li>
		    </ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="/dist/img/coffee-drying.jpg" alt="">
				</div>
				<div class="item">
					<img src="/dist/img/coffee-beans.jpg" alt="">
				</div>
				<div class="item">
					<img src="/dist/img/coffee-grind.jpg" alt="">
				</div>
				<div class="item">
					<img src="/dist/img/coffee-cup.jpg" alt="">
				</div>
				<div class="item">
					<img src="/dist/img/coffee-ground.jpg" alt="">
				</div>
			</div>
			<a class="left carousel-control" href="#coffeeCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#coffeeCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<hr />
		<div class="row text-center" style="opacity:0.7;margin-top:4em;">
			<span><i class="h1">" </i><i class="h2">high quality coffee bean seller</i><i class="h1">" </i></span>
		</div>
		<div class="row text-right" style="opacity:0.7">
			<span><i class="h2">- freeefly</i></span><br /><br /><br /><br />
		</div>
		<div class="row text-center" style="opacity:0.7">
			<span><i class="h3">We match you with coffees you'll love from over 30 of the country's best award-winning artisan coffee roasters. 
			All coffee is roasted for your order and shipped directly to you. <br /><br />
			When you get a Coffeekong coffee service, you get matched with a coffee curator - a coffee expert who learns the kinds of coffee 
			you like and sends you coffee based on your preferences.
			</i></span>
		</div>
		<hr />
		<div class="row hor_center h_nav">
			<div class="main_menu all_center" 
			style="background: url('/dist/img/coffees.jpg') no-repeat;">
				<a href="/product/list/blends"><span class="h1">COFFEE</span></a>
			</div>
			<div class="main_menu all_center" 
			style="background: url('/dist/img/tools.jpg') no-repeat center;">
				<a href="/product/list/grinder"><span class="h1">TOOLS</span></a>
			</div>
			<div class="main_menu all_center" 
			style="background: url('/dist/img/coffee_learn.jpg') no-repeat center;">
				<a href="/learn"><span class="h1">LEARN</span></a>
			</div>
		</div>
		<hr />
	</div>
	<script>
		$('.imageWrapper').on("click", 'a',function(event){
			event.preventDefault();
			
			var target = $(this).attr("href");
			var plistForm = $("#plistForm");
			plistForm.find("[name='id']").val(target);
			plistForm.attr("action","/product/detail");
			plistForm.attr("method", "GET");
			plistForm.submit();
		})

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