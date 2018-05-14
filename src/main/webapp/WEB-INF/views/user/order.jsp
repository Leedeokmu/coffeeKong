<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="basePath" value="${pageContext.request.contextPath }" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test="${fn:length(cart) > 0}">
	<form method="post" action="/order" name="order">
		<input type="hidden" name="o_price" />
		<div class="container">
			<div class="row">
				<h3 class="u_title text-center">Product Information</h3>
			</div>
			<c:forEach var="cvo" items="${cart}" varStatus="index" step="1">
				<div class="hor_center u_article" style="margin-top: 1em">
					<div class="row hor_center" style="width: 40em">
						<div class="col-md-4">
							<img src="${cvo.p_img }" width="150" height="150" alt="product" />
						</div>
						<div class="col-md-8 text-center">
							<div class="row">
								<div class="col-md-4">
									<span><b>name</b></span>
								</div>
								<div class="col-md-8">
									<span>${cvo.p_name }</span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<span><b>subprice</b></span>
								</div>
								<div class="col-md-8">
									<span class="subprice">${cvo.sub_price }</span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<span><b>quentity</b></span>
								</div>
								<div class="col-md-8">
									<span>${cvo.qty }</span>
								</div>
							</div>
							<c:choose>
								<c:when
									test="${cvo.p_category eq 'SingleOrigins' || cvo.p_category eq 'Blends' ||cvo.p_category eq 'Decafs' ||cvo.p_category eq 'Light' ||cvo.p_category eq 'Medium' ||cvo.p_category eq 'Dark' ||cvo.p_category eq 'ColdBrew'}">
									<div class="row">
										<div class="col-md-4">
											<span><b>type</b></span>
										</div>
										<div class="col-md-8">
											<span>${cvo.type }</span>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<span><b>size</b></span>
										</div>
										<div class="col-md-8">
											<span>${cvo.sz }</span>
										</div>
									</div>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
				<hr />
			</c:forEach>
			<div class="row">
				<div class="hor_right">
					<h3 id="totalPrice"></h3>
				</div>
			</div>
			<hr />
			<div class="row u_title text-center">
				<h3>Receiver Information</h3><br />
			</div>
			<div class="row form-horizontal">
				<label class="control-label col-md-2">receiver</label>
				<div class="col-md-5"> 
					<input class="form-control" type="text" name="o_rfname" placeholder="YOUR FIRST NAME" />
				</div>
				<div class="col-md-5">
					<input class="form-control" type="text" name="o_rlname" placeholder="YOUR LAST NAME" />
				</div>
			</div>
			<div class="row form-horizontal">
				<label class="control-label col-md-2">postcode</label>
				<div class="col-md-10">
					<input class="form-control" type="text" name="o_postcode" placeholder="ENTER YOUR POSTCODE"/>
				</div>
			</div>
			<div class="row form-horizontal">
				<label class="control-label col-md-2">address</label>
				<div class="col-md-10">
					<textarea class="form-control" name="o_addr" cols="30" rows="2"></textarea>
				</div>
			</div>
			<div class="row form-horizontal">
				<label class="control-label col-md-2">phone</label>
				<div class="col-md-10">
					<input class="form-control" type="text" name="o_phone" value="1111111111" placeholder="ENTER YOUR PHONE NUMBER"/>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="hor_center">
					<input type="submit" name="sendOrder" class="btn btn-success btn-lg" value="ORDER"/>
				</div>
			</div>
		</div>
	</form>
	</c:when>
	<c:otherwise>
		<div class="container">
			<div class="text-center">
				<h2>YOUR CART EMPTY</h2><br />
				click <a href="/product/list/Blends">here</a> to navigate products.
			</div>
		</div>
	</c:otherwise>
	</c:choose>
	
	<script>
		$(document).ready(function(){
			var totalPrice = 0;
			$('.subprice').each(function(){
				totalPrice += parseFloat($(this).text());
			})
			$('#totalPrice').text('Total Price : $'+totalPrice.toFixed(2));
			$('input[name="o_price"]').attr('value', totalPrice);
			
			
		})	
	</script>
</body>
</html>